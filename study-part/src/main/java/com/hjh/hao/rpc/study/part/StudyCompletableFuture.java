package com.hjh.hao.rpc.study.part;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 学习下completableFuture的api
 *
 * @author haojiahong created on 2019/12/11
 */
public class StudyCompletableFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        testSupplyAsync();
    }

    /**
     * supplyAsync 方法会直接执行计算
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void testSupplyAsync() throws ExecutionException, InterruptedException {

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            return "aaa";
        });
        System.out.println(future.get());
    }

    public static int getMoreData() {
        long t = System.currentTimeMillis();
        System.out.println("begin to start compute");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end to start compute. passed " + (System.currentTimeMillis() - t) / 1000 + " seconds");
        Random random = new Random();
        return random.nextInt(1000);
    }


}
