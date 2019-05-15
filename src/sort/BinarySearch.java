package sort;

import java.util.HashMap;

public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {4,5,6,7,8,10};
        int index = binearySearch1(array, 4);
        System.out.println(index);
        int[] array1 = {1,3,4,5,6,8,8,8,10,11};
        System.out.println(firstBiggerEquals(array1, 7));

    }

    //二分查找for循环实现
    private static int binearySearch(int[] array, int value) {
        if (array == null) return -1;

        int left = 0;
        int right = array.length - 1;
        while (left <= right) { //注意这里，必须包含=
            int mid = left + (right - left) / 2;
            if (array[mid] == value) {
                return mid;
            } else if (array[mid] > value) {
                right = mid - 1;
            } else if (array[mid] < value) {
                left = mid + 1;
            }
        }

        return -1;
    }

    //二分查找递归实现
    private static int binearySearch1(int[] array, int value) {
        return binearySearch1Internall(array, 0, array.length -1, value);
    }

    private static int binearySearch1Internall(int[] array, int left, int right, int value) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) /2;
        if (array[mid] == value) {
            return mid;
        } else if (array[mid] < value) {
            return binearySearch1Internall(array, mid + 1, right, value);
        } else if (array[mid] > value) {
            return binearySearch1Internall(array, left, mid - 1, value);
        }
        return -1;

    }


    /**  以下是二分查找的变体 **/

    //查找第一个值等于给定值的元素
    private static int firstEquals(int array[], int value) {
        if (array == null) {
            return -1;
        }
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] > value) {
                high = mid - 1;
            } else if (array[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == 0 || array[mid -1] < value) return mid;
                else high = mid - 1;
            }
        }
        return -1;
    }

    //查找最后一个值=给定的值
    private static int finalEquals(int array[], int value) {
        if (array == null) {
            return -1;
        }
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] > value) {
                high = mid - 1;
            } else if (array[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == array.length - 1 || array[mid + 1] > value) return mid;
                else high = mid - 1;
            }
        }
        return -1;
    }

    //查找第一个值大于等于给定值的元素
    private static int firstBiggerEquals(int array[], int value) {
        if (array == null) {
            return -1;
        }
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] >= value) {
                if (mid == 0 || array[mid - 1] < value) return mid;
                else high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    //查找最后一个值=给定的值
    private static int finalLessEquals(int array[], int value) {
        if (array == null) {
            return -1;
        }
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == array.length - 1 || array[mid + 1] > value) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

}
