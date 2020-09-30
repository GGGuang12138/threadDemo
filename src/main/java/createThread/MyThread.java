package createThread;

/**
 * Creat by GG
 * Date on 2020/9/26  5:00 下午
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0;i < 10;i++){
            System.out.println("我是demo00线程");
        }
    }

    public static void main(String[] args) {
        //创建线程对象
        MyThread myThread = new MyThread();

        //调用start()开启线程
        myThread.start();

        //调用run()在主线程中运行run方法
        myThread.run();

        //主线程
        for (int i = 0; i < 100; i++){
            System.out.println("我是朱线程");
        }
    }
}
