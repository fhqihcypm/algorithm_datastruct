package leetcode;

import java.util.HashMap;
import java.util.Map;

class TwoSum {

    /**
     * 利用map查询复杂度为O(1)的特性
     * 遍历整个数组，去map中查找target-nums[i]的值是否存在map中，如果存在则找到答案
     * 如果不存在则把nums[i]保存到map中
     *
     * 即用空间换时间
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        if(nums == null ) return null;
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++) {
            int tt = target - nums[i];
            if (map.get(tt) != null) {
                return new int[]{i, map.get(tt)};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int input[] = {2,7,6,7,10};
        System.out.println(twoSum(input, 9));
    }
}