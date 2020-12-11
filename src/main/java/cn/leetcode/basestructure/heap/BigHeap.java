package cn.leetcode.basestructure.heap;

/**
 * dsc: BigHeap 大堆
 * date: 2020/12/7 19:12
 * author: zyc
 */
public class BigHeap {
    private int [] elements = new  int[10];
    private volatile int elementCount = 0;//元素数量

    /**
     * 元素1存储在第一个位置，索引为0，那他的左孩子节点的下标索引为 parent * 2 + 1 = 1，
     * 右孩子节点的下标索引为 parent * 2 + 2 = 2；但是如果我们把第一个元素的下标索引定义为 1 ，
     * 那么左孩子的下标索引为 parent * 2 = 2，右孩子节点的下标索引为 parent * 2 + 1 = 3。
     */
    public void add(int d){
        elements[++elementCount] = d;//加入数组位置
        if(elementCount==1){
            return;
        }
        floatElement(elementCount);
    }

    //上浮
    public void shftUp(int i){

    }


    /**
     * 元素上浮
     * @param index 上浮元素索引位置
     */
    private void floatElement(int index) {
        //index /2 就是父类  还有跳出条件
        while (index > 1 && elements[index >> 1] < elements[index]) {
            swap(index >> 1, index);
            index >>= 1;
        }
    }

    /**
     * 弹出队列
     * @return  返回队列最大或者最小值
     */
    public int pop() {
        int res = elements[1];
        swap(1, elementCount);
        elements[elementCount--] = 0;
        sinkElement();
        return res;
    }
    /**
     * 元素下沉
     */
    private void sinkElement() {
        int index = 1;
        while (index << 1 <= elementCount &&
                (elements[index] < elements[index << 1] || elements[index] < elements[(index << 1) + 1])) {
            int p = index << 1;
            int i = elements[p] > elements[p + 1] ? p : p + 1;
            swap(index, i);
            //(i & 0x01) == 1 i 是否大于等于1
            index = (i & 0x01) == 1 ? (index << 1) + 1 : index << 1;
        }
    }

    /**
         * 交换数组两元素位置
         * @param indexA    元素A的索引位置
         * @param indexB    元素B的索引位置
         */
    private void swap(int indexA, int indexB) {
        int temp = elements[indexA];
        elements[indexA] = elements[indexB];
        elements[indexB] = temp;
    }


    public static void main(String[] args) {
        int [] datas = {1,23,4,5,21,34,66,3,24};

        BigHeap bigHeap = new BigHeap();
        for (int i = 0; i < datas.length; i++) {
            int data = datas[i];
            bigHeap.add(data);
        }

        for (int i = 0; i < bigHeap.elements.length; i++) {
            System.out.println(bigHeap.elements[i]);
        }
    }

}
