package com.yll.study;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 一个数组中有一种数出现了奇数次，其它数都出现了偶数次，怎么找到并打印这个数？
 */
public class CountOddOccurrencesByXOR {
    public static void main(String[] args) {
        System.out.println(searchNum(new int[]{1, 1, 2, 2, 3,   5, 5}));
        System.out.println(searchNumByXOR(new int[]{1, 1, 2, 2, 3,   5, 5}));
    }

    // 方法一：用HashMap建表找
    public static int searchNum(int[] arr){
        int length = arr.length;
        HashMap<String,Integer> map = new HashMap<>();

        for (int i : arr) {
            if (map.containsKey(i+"")){
                int t = map.get(i+"");
                map.put(i+"",++t);
            }else {
                map.put(i+"",1);

            }
        }

        // 复习一下Stream流，通过filter进行筛选
        Optional<Map.Entry<String, Integer>> first = map.entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst();
        // 如果没找到就为null 方便后续的判断
        Map.Entry<String, Integer> entry = first.orElse(null);

        return entry!=null?Integer.parseInt(entry.getKey()):-1;
    }


    /**
     * 方法二：通过异或进行查找！只需要一个额外空间，不像HashMap！
     */
    public static int searchNumByXOR(int[] arr){
        int xor = 0;
        for (int i : arr) {
            xor ^= i;
        }

        return xor;

        /**
         * 思路：
         * 首先需要知道：异或是相同为0，不同为一，则两个偶数在一次异或，就会为0
         *      1^1 = 0; 2^2 = 0;
         * 其次：任何数异或0都等于它本身---1^0 = 1; 123^0 = 123
         * 所以只需要新创建一个变量，为他赋初始值为0，并且循环遍历一次arr数组，让变量从头到位异或一次
         * 那么偶数个的数则都会异或变成0，最后只剩下一个奇数个的数字。
         * 例：1,1,2,2,3,4,4
         * 1^1 = 0 --> 0^2 = 2 --> 2^2 = 0 --> 0^3 = 3 --> 3^4 = 3^4（懒得算了，转二进制异或完再转回来） --> 3^4^4 = 3
         * 则最后结果为3
         *
         * 注：这个方法只适用于只有一个奇数次个数的场合
         */
    }
}
