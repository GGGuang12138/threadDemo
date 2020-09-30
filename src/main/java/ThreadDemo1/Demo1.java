package ThreadDemo1;

/**
 * 多个线程同时操作一个对象
 * 情景：买火车票
 * 问题：多个线程操作同一个资源，线程不安全，出现数据混乱
 * Creat by GG
 * Date on 2020/9/26  7:52 下午
 */
public class Demo1 implements Runnable{
    private int ticketNums = 10;

    public void run() {
        while (true){
            if (ticketNums<=0){
                break;
            }
            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "---->拿到了第" + ticketNums-- + "票");
        }
    }

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        Thread thread1 = new Thread(demo1, "老王");
        Thread thread2 = new Thread(demo1, "老郑");
        Thread thread3 = new Thread(demo1, "老陈");

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
