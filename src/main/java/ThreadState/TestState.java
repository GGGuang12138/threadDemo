package ThreadState;

/**
 * 观察线程不同状态
 * Creat by GG
 * Date on 2020/9/29  8:49 下午
 */
public class TestState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                Thread.State state = Thread.currentThread().getState();
                System.out.println(state);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("/////");
        });

        //new
        Thread.State state = thread.getState();
        System.out.println(state);

        //runnable
        thread.start();
        state = thread.getState();
        System.out.println(state);

        //time_waiting
        while (state != Thread.State.TERMINATED){
            Thread.sleep(100);
            state = thread.getState();
            System.out.println(state);
        }
        //无法再次执行
        thread.start();


    }
}
