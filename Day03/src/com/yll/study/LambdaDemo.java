package com.yll.study;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Lambda表达式的一些用法
 */
public class LambdaDemo {
    public static void main(String[] args) {


        // 遍历List中的数据
        List<String> list = Arrays.asList("Apple","aaa","xx");
        list.forEach(s -> System.out.println(s));
        list.forEach(System.out::println);

        // 为List中的数据进行排序
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        Collections.sort(list,(o1,o2)->o1.compareTo(o2));
        list.forEach(System.out::println);

        // 查找a开头的字符串
        List<String> list2 = new ArrayList<>();
        for (String s : list) {
            if (s.startsWith("a")){
                list2.add(s);
            }
        }
        List<String> list3 = list.stream().filter(s->s.startsWith("a")).collect(Collectors.toList());

        // 算累加和
        List<Integer> listInt = Arrays.asList(1,3,5,4,8);
        int sum = 0;
        for (Integer integer : listInt) {
            sum+=integer;
        }

        int sum2 = listInt.stream().reduce(0,(a,b)->a+b);

    }
}
