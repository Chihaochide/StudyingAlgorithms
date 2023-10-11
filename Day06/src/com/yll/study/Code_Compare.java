package com.yll.study;

import java.util.Arrays;
import java.util.TreeMap;

public class Code_Compare {
    public static void main(String[] args) {
        Student s1 = new Student("A",3,24);
        Student s2 = new Student("B",1,22);
        Student s3 = new Student("C",2,25);
        Student[] students = new Student[]{s1,s2,s3};
        System.out.println(students[0].toString());
        Arrays.sort(students,new Student.AgeASCOrder());
        System.out.println(Arrays.toString(students));

        Arrays.sort(students,new Student.IdDescOrder());
        System.out.println(Arrays.toString(students));

        System.out.println("=============================");
//        TreeMap<Student,String> treeMap = new TreeMap<>(new Student.IdASCAgeDescOrder());
        TreeMap<Student,String> treeMap = new TreeMap<>((a,b)->a.id-b.id);

        treeMap.put(s1,"我是学生1，我的名字叫A");
        treeMap.put(s2,"我是学生2，我的名字叫B");
        treeMap.put(s3,"我是学生3，我的名字叫C");

        for (Student s :treeMap.keySet()){
            System.out.println(s.toString());
        }


    }
}
