package createThread;

import java.util.concurrent.*;

/**
 * 实现Callable接口
 * 使用Executors类、或FutureTask类创建，有返回值
 * Creat by GG
 * Date on 2020/9/26  8:33 下午
 */
public class MyCallable implements Callable<Boolean> {

    public Boolean call() throws Exception {
        for (int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + "执行了" + i +"步");
        }
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        //提交线程
        Future<Boolean> res1 = executorService.submit(new MyCallable());
        Future<Boolean> res2 = executorService.submit(new MyCallable());
        Future<Boolean> res3 = executorService.submit(new MyCallable());
        //获取结果
        Boolean aBoolean = res1.get();
        Boolean aBoolean2 = res2.get();
        Boolean aBoolean3 = res3.get();
        //关闭服务
        executorService.shutdown();
    }
}
