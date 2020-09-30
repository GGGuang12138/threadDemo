package lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentranLock解决多线程抢票问题，性能优于synchronized
 * Creat by GG
 * Date on 2020/9/30  5:47 下午
 */
public class LockTest {
    public static void main(String[] args) {
        LockTest2 lockTest2 = new LockTest2();
        new Thread(lockTest2,"一号").start();
        new Thread(lockTest2,"二号").start();
    }
}
class LockTest2 implements Runnable{
    static int ticketNums = 10;

    private final ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //加锁
            lock.lock();
            try {
                if (ticketNums > 0){
                    System.out.println(Thread.currentThread().getName()+ticketNums--);
                }else{
                    break;
                }
            }finally {
                //解锁
                lock.unlock();
            }
        }
    }
}