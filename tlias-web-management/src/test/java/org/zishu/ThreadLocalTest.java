package org.zishu;


public class ThreadLocalTest {

    private static ThreadLocal<String> local = new ThreadLocal<>();

    /**
     * 主线程存，主线程取，主线程删
     * @param args
     */
    public static void main(String[] args){
        local.set("Main Message");

        //创建一个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                local.set("Sub Message");
                System.out.println(Thread.currentThread().getName() + " : " + local.get());
            }
        }).start();

        System.out.println(Thread.currentThread().getName() + " : " + local.get());

        local.remove();

        System.out.println(Thread.currentThread().getName() + " : " + local.get());

    }
}
