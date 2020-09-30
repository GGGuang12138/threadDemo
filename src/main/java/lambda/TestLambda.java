package lambda;

/**
 * Creat by GG
 * Date on 2020/9/28  10:38 上午
 */
public class TestLambda {

    //3.静态内部类
    static class Like2 implements ILike{
        public void lambda() {
            System.out.println("I like lambda2");
        }
    }
    public static void main(String[] args) {
        //接口实现类
        ILike like = new Like();
        like.lambda();

        //静态内部类
        Like2 like2 = new Like2();
        like2.lambda();

        //4.局部内部类
        class Like3 implements ILike{

            public void lambda() {
                System.out.println("I like lambda3");
            }
        }
        Like3 like3 = new Like3();
        like3.lambda();

        //5.匿名内部类
        ILike like4 = new ILike() {
            public void lambda() {
                System.out.println("I like lambda4");
            }
        };
        like4.lambda();


         ILike like5 = ()->{
            System.out.println("I like Lambda5");
         };
         like5.lambda();
    }

}

//1.定义一个函数式接口
interface ILike{
    void lambda();
}
//2.接口实现类
class Like implements ILike{

    public void lambda() {
        System.out.println("I like lambda");
    }
}
