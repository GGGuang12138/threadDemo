package staticProxy;

/**
 * 代理模式模拟结婚事件
 * 代理对象对应 婚庆公司、真实角色对应 人、接口对应 结婚
 * Creat by GG
 * Date on 2020/9/28  8:32 下午
 */
public class StaticProxy{

    public static void main(String[] args) {
        You you = new You();
        new MarryCompany(you).happyMarry();

    }
}

interface Marry{
    void happyMarry();
}
class You implements Marry{

    @Override
    public void happyMarry() {
        System.out.println("结婚");
    }
}
class MarryCompany implements Marry{

    private Marry target;

    public MarryCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        before();
        this.target.happyMarry();
        after();
    }
    public void before(){
        System.out.println("装饰婚礼现场");
    }
    public void after(){
        System.out.println("收尾款");
    }


}


