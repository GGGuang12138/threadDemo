package createThread;

/**
 * 避免单继承的局限性，方便一个对象被多个线程使用
 * Creat by GG
 * Date on 2020/9/26  7:33 下午
 */
public class MyRunnable implements Runnable {
    public void run() {
        for (int i = 0; i < 20; i++){
            System.out.println("runnable 线程");
        }
    }

    public static void main(String[] args) {
        //创建runnable接口的实现类
        MyRunnable myRunnable = new MyRunnable();

        //创建线程对象，通过线程对象开启我们的线程代理
        Thread thread = new Thread(myRunnable,"线程名");
        thread.start();

        //主线程
        for (int i = 0; i < 200; i++){
            System.out.println("朱线程");
        }
    }
}
