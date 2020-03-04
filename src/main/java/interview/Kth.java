package interview;


public class Kth {

    public static void main(String[] args) {

    }

    private static void find20Smallest(int[] arr, int left, int right){
        //输入合法性校验
        if (arr.length <= 0){
            return;
        }
        if (left > right) {
            return;
        }

        //标记游标元素
        int p = arr[left];
        int i = left, j = right;
        while (i <j) {
            //找到左边大于p的元素
            if (arr[i] <= p) {
                i++;
            } else {
                swap(arr[i], arr[j]);
            }

            //找打右边小于p的元素
            if (arr[j] > p) {
                j--;
            } else {
                swap(arr[++i], arr[j]);
            }
        }
        //为标记元素找到对应位置
        swap(arr[i], arr[left]);
        //等于20找到
        if (i == 20){
            return;
        }
        //大于20 只对左边进行递归
        else if (i > 20){
            find20Smallest(arr, 0, i);
        }
        //小于20 对右边进行递归
        else {
            find20Smallest(arr, i, right);
        }
    }

    private static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

}
