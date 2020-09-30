package socket;

/**
 * 使用管程法解决生产者消费者问题
 * Creat by GG
 * Date on 2020/9/30  6:21 下午
 */
public class TestPC {
    public static void main(String[] args) {
        SynContainer synContainer = new SynContainer();
        new Producer(synContainer).start();
        new Consumer(synContainer).start();
    }
}

class Producer extends Thread{
    SynContainer container;
    public Producer(SynContainer container){
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("生产了"+ i + "只鸡");
            container.push(new Chicken(i));
        }
    }
}

class Consumer extends Thread{
    SynContainer container;
    public Consumer(SynContainer container){
        this.container = container;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Chicken chicken = container.pop();
            System.out.println("消费了"+ chicken.id + "只鸡");
        }
    }
}

class Chicken{
    int id;
    public Chicken(int id){
        this.id = id;
    }

}

class  SynContainer{
    Chicken[] chickens = new Chicken[10];

    //容器
    int count = 0;

    //生产者放入产品
    public synchronized void push(Chicken chicken){
        //满了
        if (count == chickens.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //生产
        chickens[count] = chicken;
        count ++;
        this.notifyAll();
    }

    //消费者取出
    public synchronized Chicken pop(){
        //没了
        if (count == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //取出
        count --;
        Chicken chicken = chickens[count];
        this.notifyAll();
        return chicken;
    }
}