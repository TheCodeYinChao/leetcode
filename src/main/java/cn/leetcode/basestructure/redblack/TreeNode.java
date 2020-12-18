package cn.leetcode.basestructure.redblack;


import java.util.HashMap;

/**
 * dsc: TreeNode
 *  红黑树实现，摘抄至 hashmap
 * date: 2020/12/18 18:09
 * author: zyc
 */
public class TreeNode {
        TreeNode parent;  // red-black tree links
        TreeNode left;
        TreeNode right;
        boolean red;
        int val;

        TreeNode( int val) {
            this.val = val;
        }
    TreeNode( ) {
        this.val = val;
    }
        /**
         * Returns root of tree containing this node.
         */
        final TreeNode root() {
            for (TreeNode r = this, p;;) {
                if ((p = r.parent) == null)
                    return r;
                r = p;
            }
        }



        /**
         * Forms tree of the nodes linked from this node.
         * @return root of tree
         */
        final TreeNode add(TreeNode root,Integer val) {
            TreeNode x = new TreeNode(val);
            for (TreeNode p = root;;) {//p指向遍历中的当前节点 x待插入节点
                int dir = 0, ph;
                if ((ph = p.val) > val)//这里通过hash来确定树的左边还是右边
                    dir = -1;
                else if (ph < val)
                    dir = 1;

                TreeNode xp = p;
                if ((p = (dir <= 0) ? p.left : p.right) == null) {
                    x.parent = xp;
                    if (dir <= 0)
                        xp.left = x;
                    else
                        xp.right = x;
                    root = balanceInsertion(root, x);
                    break;
                }
            }
            return root;
        }



    /**
     *  左旋
     * @param root
     * @param p
     * @param <K>
     * @param <V>
     * @return
     */

        static <K,V> TreeNode rotateLeft(TreeNode root,
                                                      TreeNode p) {
            TreeNode r, pp, rl;
            if (p != null && (r = p.right) != null) {
                if ((rl = p.right = r.left) != null)
                    rl.parent = p;
                if ((pp = r.parent = p.parent) == null)
                    (root = r).red = false;
                else if (pp.left == p)
                    pp.left = r;
                else
                    pp.right = r;
                r.left = p;
                p.parent = r;
            }
            return root;
        }
    /**
     *  右旋
     * @param root
     * @param p
     * @param <K>
     * @param <V>
     * @return
     */
        static <K,V> TreeNode rotateRight(TreeNode root,
                                                       TreeNode p) {
            TreeNode l, pp, lr;
            if (p != null && (l = p.left) != null) {
                if ((lr = p.left = l.right) != null)
                    lr.parent = p;
                if ((pp = l.parent = p.parent) == null)
                    (root = l).red = false;
                else if (pp.right == p)
                    pp.right = l;
                else
                    pp.left = l;
                l.right = p;
                p.parent = l;
            }
            return root;
        }

        static <K,V> TreeNode balanceInsertion(TreeNode root,//https://www.cnblogs.com/mfrank/p/9227097.html 博客
                                                            TreeNode x) {//x新增节点
            x.red = true;//新增全设置为red
            for (TreeNode xp, xpp, xppl, xppr;;) {
                if ((xp = x.parent) == null) {
                    x.red = false;//第一个条件，根节点为黑色
                    return x;
                }
                else if (!xp.red || (xpp = xp.parent) == null)
                    return root;//父级节点就是根节点
                if (xp == (xppl = xpp.left)) {//xp父级位于x pp 的左边
                    if ((xppr = xpp.right) != null && xppr.red) {//祖父级别的右节点不为空，
                        xppr.red = false;
                        xp.red = false;
                        xpp.red = true;
                        x = xpp;
                    }
                    else {//祖父级别的有节点为空
                        if (x == xp.right) {//左右
                            root = rotateLeft(root, x = xp);
                            xpp = (xp = x.parent) == null ? null : xp.parent;
                        }
                        if (xp != null) {
                            xp.red = false;
                            if (xpp != null) {
                                xpp.red = true;//左左色不对
                                root = rotateRight(root, xpp);
                            }
                        }
                    }
                }
                else {//xp位于xpp 的右边
                    if (xppl != null && xppl.red) {
                        xppl.red = false;
                        xp.red = false;
                        xpp.red = true;
                        x = xpp;
                    }
                    else {
                        if (x == xp.left) {//右左
                            root = rotateRight(root, x = xp);
                            xpp = (xp = x.parent) == null ? null : xp.parent;
                        }
                        if (xp != null) {//右右
                            xp.red = false;
                            if (xpp != null) {
                                xpp.red = true;
                                root = rotateLeft(root, xpp);
                            }
                        }
                    }
                }
            }
        }

        static <K,V> TreeNode balanceDeletion(TreeNode root,
                                                           TreeNode x) {
            for (TreeNode xp, xpl, xpr;;)  {
                if (x == null || x == root)
                    return root;
                else if ((xp = x.parent) == null) {
                    x.red = false;
                    return x;
                }
                else if (x.red) {
                    x.red = false;
                    return root;
                }
                else if ((xpl = xp.left) == x) {
                    if ((xpr = xp.right) != null && xpr.red) {
                        xpr.red = false;
                        xp.red = true;
                        root = rotateLeft(root, xp);
                        xpr = (xp = x.parent) == null ? null : xp.right;
                    }
                    if (xpr == null)
                        x = xp;
                    else {
                        TreeNode sl = xpr.left, sr = xpr.right;
                        if ((sr == null || !sr.red) &&
                                (sl == null || !sl.red)) {
                            xpr.red = true;
                            x = xp;
                        }
                        else {
                            if (sr == null || !sr.red) {
                                if (sl != null)
                                    sl.red = false;
                                xpr.red = true;
                                root = rotateRight(root, xpr);
                                xpr = (xp = x.parent) == null ?
                                        null : xp.right;
                            }
                            if (xpr != null) {
                                xpr.red = (xp == null) ? false : xp.red;
                                if ((sr = xpr.right) != null)
                                    sr.red = false;
                            }
                            if (xp != null) {
                                xp.red = false;
                                root = rotateLeft(root, xp);
                            }
                            x = root;
                        }
                    }
                }
                else { // symmetric
                    if (xpl != null && xpl.red) {
                        xpl.red = false;
                        xp.red = true;
                        root = rotateRight(root, xp);
                        xpl = (xp = x.parent) == null ? null : xp.left;
                    }
                    if (xpl == null)
                        x = xp;
                    else {
                        TreeNode sl = xpl.left, sr = xpl.right;
                        if ((sl == null || !sl.red) &&
                                (sr == null || !sr.red)) {
                            xpl.red = true;
                            x = xp;
                        }
                        else {
                            if (sl == null || !sl.red) {
                                if (sr != null)
                                    sr.red = false;
                                xpl.red = true;
                                root = rotateLeft(root, xpl);
                                xpl = (xp = x.parent) == null ?
                                        null : xp.left;
                            }
                            if (xpl != null) {
                                xpl.red = (xp == null) ? false : xp.red;
                                if ((sl = xpl.left) != null)
                                    sl.red = false;
                            }
                            if (xp != null) {
                                xp.red = false;
                                root = rotateRight(root, xp);
                            }
                            x = root;
                        }
                    }
                }
            }
        }

    @Override
    public String toString() {
            return val+"";
    }
}
