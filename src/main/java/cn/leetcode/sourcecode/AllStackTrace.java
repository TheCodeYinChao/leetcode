package cn.leetcode.sourcecode;

import java.util.Map;
import java.util.Set;

/**
 * @Author xiaoya.wen@raykite.com
 * @Date 2021/02/18  18:07
 **/
public class AllStackTrace {
    public static void main(String[] args) {
        Map<Thread, StackTraceElement[]> all = Thread.getAllStackTraces();
        Set<Map.Entry<Thread, StackTraceElement[]>> entries = all.entrySet();
        for (Map.Entry<Thread, StackTraceElement[]> en : entries) {
            Thread t = en.getKey();
            StackTraceElement[] v = en.getValue();
            System.out.println("【Thread name is ：" + t.getName() + "】");
            for (StackTraceElement s : v) {
                System.out.println("\t" + s.toString());
            }
        }
    }
}
