package lambda;

/**
 * Creat by GG
 * Date on 2020/9/28  11:15 上午
 */
public class TestLambda2 {
    public static void main(String[] args) {
        ILove love = (a) ->{
            System.out.println( "I Love you " + a + " years");
        };
        love.lambda(3000);

        // 一个参数且执行内容一行
        ILove love1 = a-> System.out.println("I Love you " + a + " years");
        love1.lambda(4000);
    }

}
interface ILove{
    void lambda(int a);
}
