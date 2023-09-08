package com.yll.study;

/**
 * 有两个数字在数组中出现了奇数次，其余都是偶数次，找到那两个数字
 */
public class CountOddByXOR {
    public static void main(String[] args) {
        printOddTimesNum(new int[]{1,1,2,2,3,4,5,5,6,6});
    }
    public static void printOddTimesNum(int[] nums){
        int eor = 0;
        for (int num : nums) {
            eor ^= num;
        }
        int rightOne = eor&(-eor);
        int onlyOne = 0;
        for (int i = 0;i<nums.length;i++){

            if ((nums[i]&rightOne)!=0){
                onlyOne ^= nums[i];
            }
        }
        System.out.println(onlyOne+"onlyOne = "+(eor^onlyOne));
    }
}
