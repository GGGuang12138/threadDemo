package socket;

/**
 * 测试生产者消费者问题2：信号灯法
 * Creat by GG
 * Date on 2020/9/30  9:53 下午
 */
public class TestPC2 {
    public static void main(String[] args) {
        TV tv = new TV();
        new Player(tv).start();
        new Watcher(tv).start();
    }
}
//演员
class Player extends Thread{
    TV tv;
    public Player(TV tv){
        this.tv = tv;
    }
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i%2 == 0){
                this.tv.play("吐槽大会");
            }else{
                this.tv.play("脱口秀大会");
            }
        }
    }
}
//观众
class Watcher extends Thread{
    TV tv;
    public Watcher(TV tv){
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}

//电视
class TV{
    //演员表演，观众等待 T
    //观众观看，演员等待 F
    String show;
    boolean flag = true;

    //表演
    public synchronized void play(String show){
        if (!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("演员表演了"+show);
        //通知观众观看
        this.notifyAll();
        this.show = show;
        this.flag = !this.flag;
    }
    //观看
    public synchronized void watch(){
        if (flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观众观看了"+show);
        //通知表演
        this.notifyAll();
        this.flag = !this.flag;
    }
}
