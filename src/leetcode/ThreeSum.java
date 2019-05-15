package leetcode;

import java.util.*;

class ThreeSum {

    /**
     * 同样用空间换时间的思想
     *
     * 用两层循环，然后去map中查找-（nums[i] + nums[j])的值
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums == null ) return null;
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int tt = -(nums[i] + nums[j]);
                Integer index = map.get(tt);
                if (index != null && index != i && index != j) {
                    int array[] = {i, j, index};
                    System.out.println(i+" " + j + " " + index);
                    Arrays.sort(array);
                    List list = new ArrayList<>();
                    list.add(nums[array[0]]);
                    list.add(nums[array[1]]);
                    list.add(nums[array[2]]);
                    result.add(list);
                } else if (map.get(nums[j]) == null){
                    map.put(nums[j],j);
                }
            }
        }
        return result;
    }

    /**
     * 先对数据排序
     * 然后遍历数组得到a, b和c分别指向最小值和最大值
     * 如果a+b+c > 0 则c向左换一个数，反之b向右换一个数。
     * 直到找到a+b+c = 0
     *
     * 算法复杂度o(N*N)
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        if(nums == null ) return null;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;//去除重复值，即当前遍历的值和前一个遍历的值一样会出现重复结果
            }
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == 0) {
                    result.add(Arrays.asList(new Integer[]{nums[i], nums[left], nums[right]}));
                    while (left<right && nums[left] == nums[left+1]){
                        left++;//去除left右侧相邻重复的值
                    }
                    while (left<right && nums[right] == nums[right - 1] ) {
                        right --;//去除right左侧相邻重复的值
                    }
                    right--;
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    left ++;
                }
            }
        }
        return  result;
    }

    public static void main(String[] args) {
        int input[] = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum2(input);
        for (int i = 0; i < result.size(); i++) {
            System.out.printf(result.get(i).toString());
        }
    }
}
