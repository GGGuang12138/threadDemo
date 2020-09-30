package ThreadDemo2;

/**
 * 龟兔赛跑模拟
 * 线程执行到100步为胜利者，比赛结束
 * Creat by GG
 * Date on 2020/9/26  8:12 下午
 */
public class Race implements Runnable{

    //胜利者
    private static String winner;

    public void run() {
        // 100米的赛道
        for (int i = 0; i <= 100; i++){

            //兔子睡觉
            if (Thread.currentThread().getName() == "兔子" && i%10 == 0 ){
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //是否结束
            if (isOver(i)){
                break;
            }
            //跑步
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "跑了"+ i + "步");
        }
    }

    private boolean isOver(int i) {
        //出现胜利者
        if (winner!=null){
            return true;
        }
        //抵达终点
        if (i >= 100){
            winner = Thread.currentThread().getName();
            System.out.println(Thread.currentThread().getName() + " is Winner");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }
}
