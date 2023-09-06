package com.yll.study;

import java.util.concurrent.*;

/**
 * 2023/9/6
 * 今日任务：先复习一下关于线程池的八股文
 */
public class ReviewThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 首先先新建一个线程池
        ThreadPoolExecutor thread = new ThreadPoolExecutor(3,5,3, TimeUnit.MINUTES
                ,new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory()
                , new ThreadPoolExecutor.AbortPolicy());

        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName()+"执行了");
            System.out.println(123);
        };

        thread.execute(runnable);
        
        Callable<String> callable = ()->{
            System.out.println(Thread.currentThread().getName()+"执行了");
            return "11";
        };
        FutureTask<String> futureTask = new FutureTask<>(callable);
        thread.submit(futureTask);
        System.out.println("futureTask = " + futureTask.get());
        thread.shutdown();

        /**
         * ThreadPoolExecutor参数介绍：
         * 1.核心线程数
         * 2.最大线程数
         * 3.线程最大的存活时间
         * 4.存活时间的时间参数
         * 5.指定任务队列
         * 6.指定线程工厂
         * 7.拒绝策略
         * ---------------
         * 5-指定任务队列可选队列：
         * 1.ArrayBlockingQueue：是基于数组结构的有界堵塞队列，先进先出（FIFO原则）
         * 2.LinkedBlockingQueue：是基于链表结构的堵塞队列，先进先出（FIFO原则）
         * 3.SynchronousQueue：不存储元素的堵塞队列
         * 4.PriorityBlockingQueue：一个具有优先级的无限堵塞队列
         * 5.DelayQueue：记不太清了ovo
         * ---------------
         * 7-拒绝策略
         * 1.AbortPolicy：这是默认的拒绝策略，当任务超过了最大线程数，就会之前抛弃任务，并抛出异常
         * 2.CallerRunPolicy：用当前调用者的线程去处理任务
         * 3.DiscardOldestPolicy：抛弃堵塞队列中最旧的任务，并执行当前的任务
         * 4.DiscardPolicy：直接抛弃任务，不抛出异常
         *
         * -------------
         * 执行流程
         * 1、当用户启动线程的时候，线程池会根据用户设置的核心线程参数，去创建对应数量的任务线程。
         * 2、当任务数量大于了当前的核心线程数，就会将额外的线程放到用户指定的任务队列中。
         * 3、当任务队列满了的时候，会根据最大线程数-核心线程数的数量，去创建对应数量的线程。
         * 4、如果任务数量超过了最大的线程数量，那么就会根据用户指定的拒绝策略去对新进来的任务进行拒绝。
         * 5、当任务执行完成之后，刚才根据最大线程数量-核心线程数量创建的线程会根据指定的线程存活时间去进行回收。
         */

    }
    }
