package sort;

/**
 * 冒泡排序、插入排序、选择排序
 */
public class NxNSort {

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
            array[j+1] = val;
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
        for (int i : bubbleSort(array)) {
            System.out.println(i);
        }
    }

}
