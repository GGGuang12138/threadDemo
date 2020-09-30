package syn;

/**
 * 使用synchronized同步代码块，解决多线程访问银行账户问题
 * Creat by GG
 * Date on 2020/9/29  10:05 下午
 */
public class UnSafeBank {
    public static void main(String[] args) {
        //账户
        Account account = new Account(100,"结婚基金");
        Drawing drawing1 = new Drawing(account, 100, "一号");
        Drawing drawing2 = new Drawing(account, 50, "二号");
        drawing1.start();
        drawing2.start();
    }

}

class Account{
    public int money;
    public String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

class Drawing extends Thread {
    //账号
    Account account;

    //余额
    int drawingMoney;

    //手里的钱
    int nowMoney;

    public Drawing(Account account, int drawingMoney,String name) {
        //重写构造函数，实现自定义线程名
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    public void run() {

        synchronized (account){
            //判断余额是否够
            if (account.money - drawingMoney<0){
                System.out.println(Thread.currentThread().getName() + "钱不够，取不了");
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //余额变化
            account.money = account.money - drawingMoney;
            //手里的钱变化
            nowMoney = nowMoney + drawingMoney;

            System.out.println(this.getName() + "手里有" + nowMoney);
            System.out.println(account.name + "账号余额有" + account.money);
        }
        }

}