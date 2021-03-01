package cn.leetcode.sourcecode;

/**
 * @Author xiaoya.wen@raykite.com
 * @Date 2021/01/12  14:59
 **/
public class FinalizeDemo {
    public static FinalizeDemo obj;

    @Override
    protected void finalize() throws Throwable {
        System.out.println("调用当前类重写的finalize()方法");
        obj = this;
    }

    public static void main(String[] args) {
        try {
            obj = new FinalizeDemo();

            obj = null;

            System.gc();
            System.out.println("第一次GC");
            Thread.sleep(2000);
            if (obj == null) {
                System.out.println("obj已经被回收");
            } else {
                System.out.println("obj复活了");
            }

            System.out.println("第二次GC");
            obj = null;
            if (obj == null) {
                System.out.println("obj已经被回收");
            } else {
                System.out.println("obj复活了");
            }

            Thread.sleep(2000);
            System.out.println("第三次GC");
            obj = null;
            if (obj == null) {
                System.out.println("obj已经被回收");
            } else {
                System.out.println("obj复活了");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
