package cn.leetcode.secondario;

/**
 * 五子棋的存盘和续盘
 * <p>
 * sparseArray
 * 例：
 * 棋盘                   稀疏数组
 * 1：黑 2：白             行 列 值
 * 0 0 0 0 0 0              5 6 4
 * 0 0 0 1 0 0              1 3 1
 * 0 0 0 0 0 0      -->     3 0 2
 * 2 0 1 0 0 0              3 2 1
 * 0 0 0 0 0 2              4 5 2
 *
 * @Author xiaoya.wen@raykite.com
 * @Date 2020/12/14  14:37
 **/
public class Gobang {

    public int[][] checker;

    public static void main(String[] args) {
        Gobang gobang = new Gobang();

        gobang.initCheckerboard();

        int[][] ints = gobang.gobangChangeSparseArray();

        int[][] ints1 = gobang.sparseArrayChangeGobang(ints);
        for (int i = 0; i < ints1.length; i++) {
            for (int j = 0; j < ints1[0].length; j++) {
                System.out.print(ints1[i][j] + "\t");

            }

            System.out.println();
        }
    }

    /**
     * 初始化棋盘
     */
    public void initCheckerboard() {
        checker = new int[5][6];
        checker[1][3] = 1;
        checker[3][0] = 2;
        checker[3][2] = 1;
        checker[4][5] = 2;

    }

    /**
     * 存盘（将棋盘保存为稀疏数组）
     *
     * @return
     */
    public int[][] gobangChangeSparseArray() {
        int[][] sparseArray;

        int count = 0;
        for (int i = 0; i < checker.length; i++) {
            for (int j = 0; j < checker[0].length; j++) {
                if (checker[i][j] != 0) {

                    count++;
                }
            }
        }

        sparseArray = new int[count + 1][3];
        sparseArray[0][0] = checker.length;
        sparseArray[0][1] = checker[0].length;
        sparseArray[0][2] = count;
        count = 1;
        for (int i = 0; i < checker.length; i++) {
            for (int j = 0; j < checker[0].length; j++) {
                if (checker[i][j] != 0) {
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = checker[i][j];

                    count++;
                }
            }

        }

        return sparseArray;
    }

    /**
     * 续盘 将稀疏数组转为棋盘
     *
     * @param sparseArray
     * @return
     */
    public int[][] sparseArrayChangeGobang(int[][] sparseArray){
        int row = sparseArray[0][0];
        int col = sparseArray[0][1];
        int length = sparseArray[0][2];

        int[][] arr = new int[row][col];

        for (int i = 1; i <= length; i++) {
            arr[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        return arr;
    }
}
