package sort;

/**
 * 冒泡排序、插入排序、选择排序
 */
public class NxNSort {


    /**
     * 冒泡排序：相邻的两个数据比较，把大的数据放到后面。首次把最大的放到最后，第二次把次大的放在倒数第二的位置
     * 循环执行直到最后一次
     *
     * @param array
     * @return
     */
    public static int[]  bubbleSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            boolean isSorted = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    isSorted = true;
                }
            }

            if (!isSorted) break;
        }
        return  array;
    }

    /**
     * 插入排序：把数据分为两部分，左边为已排序部分，右边为未排序部分。然后从未排序的左边开始取一个数据val，
     * 和已排序的从右往左取值v1，如果小于则把当val的位置放入v1的值，再取另已排序的另一个数据v2，如果还
     * 小于则把v2放到原v1的位置，直到val大于某个值，则当前值的位置就是要插入的位置
     *
     * 核心思想就是右移已经排好序的数据，找到合适的位置插入未排序的值
     * @param array
     * @return
     */
    public static int[] insertionSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        for (int i = 1; i < array.length; i++) {
            int val = array[i];
            int j = i-1;
            for (; j >= 0; j--) {
                if (val < array[j]) {
                    array[j+1] = array[j];
                } else {
                    break;
                }
            }
            array[j+1] = val; //因为上面的循环已经对j减1了，所以这里用j+1
        }
        return array;
    }

    public static int[] selectionSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i +1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            int tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {4,5,6,3,2,1};
        for (int i : insertionSort(array)) {
            System.out.println(i);
        }
    }

}
