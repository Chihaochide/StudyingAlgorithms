package com.yll.study;

import java.util.Arrays;

class Solution_searchNum {


    public static int majorityElement2(int[] nums) {
        //也就是寻找众数
        //假设数组第一个元素就是众数 记录出现次数是1
        int target = nums[0];
        int times = 1;
        for(int i = 1;i < nums.length;i++){
            if(times == 0){
                //如果times = 0了 那么就需要重新更新target了
                target = nums[i];
                times = 1;
            }else if(nums[i] == target){
                //说明遇到了与target重复的数
                times++;
            }else if(nums[i] != target){
                //遇到了不是和target一样的数 就times--
                times--;
            }
        }
        //最终target中一定存储的是众数
        times = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == target){
                times++;
            }
        }
        if(times > nums.length/2){
            return target;
        }else{
            return -1;
        }
    }
    public static int majorityElement(int[] nums) {
        // 摩尔投票法
        int count = 0;
        Integer card = null;
        for(int num:nums){
            if(count==0) card = num;
            count += (card==num)?1:-1;
        }
        return card;
    }

    public static void main(String[] args) {
        int[] ints = {13,2, 3, 2,3, 3, 4 , 2, 2, 2, 2, 2,2,};
        int[] int2 = {13,2, 2,2,2,3,3,3,3};
//        System.out.println(majorityElement(int2));
//        System.out.println(majorityElement2(int2));
        Arrays.stream(ints)
                .limit(2)
                .forEach(System.out::println);
    }
}