package cn.leetcode.sourcecode;

/**
 * @Author xiaoya.wen@raykite.com
 * @Date 2021/01/26  11:31
 **/
public class JHSDB_TestCase {

    static class Test {
        static ObjectHolder staticObject = new ObjectHolder();
        static final ObjectHolder staticFinalObject = new ObjectHolder();
        final ObjectHolder finalObject = new ObjectHolder();
        ObjectHolder instanceObject = new ObjectHolder();

        void foo(){
            ObjectHolder localObj = new ObjectHolder();
            System.out.println("done");
        }

    }

    private static class ObjectHolder {
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.foo();
    }
}
