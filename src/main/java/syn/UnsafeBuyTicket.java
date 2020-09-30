package syn;

/**
 * 不安全买票问题
 * 线程共享内存，同时看到1票，同时减一导致
 * 使用synchronized同步方法解决
 * Creat by GG
 * Date on 2020/9/29  9:44 下午
 */
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();

        new Thread(station,"一号").start();
        new Thread(station,"二号").start();
        new Thread(station,"三号").start();
    }


}
class BuyTicket implements Runnable{

    //票
    private int ticketNums = 10;
    //理论上是否拿票
    boolean flag = true;

    @Override
    public void run() {
        while (flag){
            //模拟延时
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
    private synchronized void buy() throws InterruptedException {
        //判断是否有票，无票停止
        if (ticketNums <= 0){
            flag = false;
            return;
        }
        //买票
        System.out.println(Thread.currentThread().getName() + "拿到第 " + ticketNums --);
    }
}
