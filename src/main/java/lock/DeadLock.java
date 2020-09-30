package lock;

/**
 * 程序执行需要对两个资源加锁，多线程执行时，两个线程分别拥有两个锁，互相无法执行完成，形成死锁
 * 解决方案：程序获得一个锁执行结束释放锁，再获取第二个锁
 * Creat by GG
 * Date on 2020/9/30  5:11 下午
 */
public class DeadLock {
    public static void main(String[] args) {
        MakeUp makeUp1 = new MakeUp(0, "灰姑娘");
        MakeUp makeUp2 = new MakeUp(1, "灰姑娘");

        makeUp1.start();
        makeUp2.start();
    }

}
class Lipstick{

}
class Mirror{

}
class MakeUp extends Thread{

    //用static保证资源只有一份，由类拥有
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice; //选择
    String girlName;

    MakeUp(int choice, String girlName){
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        //化妆
        makeUp();
    }
    private void makeUp(){
        if (choice == 0){
            synchronized (lipstick){//获得口红锁
                System.out.println(this.girlName + "获得口红的锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (mirror){
                    System.out.println(this.girlName + "获得镜子的锁");
                }
            }
        }else{
            synchronized (mirror){//获得口红锁
                System.out.println(this.girlName + "获得镜子的锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lipstick){
                    System.out.println(this.girlName + "获得口红的锁");
                }
            }
        }
    }
}
