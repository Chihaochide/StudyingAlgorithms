package com.yll.study;

import java.util.Comparator;

public class Student {
    public String name;
    public Integer id;
    public Integer age;

    public Student(String name, Integer id, Integer age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }

    // 任何比较器：
    // compare方法里，遵循一个统一的规范：
    // 返回负数的时候，认为第一个参数应该排到前面
    // 返回正数的时候，认为第二个参数应该排到前面
    // 返回0的时候，谁排前面都可以
    public static class AgeASCOrder implements Comparator<Student> {

        @Override
        public int compare(Student o1,Student o2) {
//            if (o1.age<o2.age){
//                return -1;
//            }else if(o1.age>o2.age){
//                 return 1;
//            }
//            return 0;
            return o1.age-o2.age;
        }
    }

    public static class IdDescOrder implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2) {
            return o2.id-o1.id;
        }
    }

    public static class IdASCAgeDescOrder implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2) {
            return o1.id != o2.id ? (o1.id-o2.id):(o2.age-o1.age);
        }
    }
}
