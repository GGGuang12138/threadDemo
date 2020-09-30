package lambda;

import java.util.PriorityQueue;

/**
 * Creat by GG
 * Date on 2020/9/28  10:14 下午
 */
public class TestLambda3 {

    public static void main(String[] args) {
        Student vip1 = new Student("􏵹􏳬1号", 1);
        Student vip3 = new Student("􏾺􏾻2号", 2);
        Student vip4 = new Student("􏽭􏾼3号", 4);
        Student vip2 = new Student("􏾬􏴵4号", 1);
        Student normal1 = new Student("􏾭5号􏾮", 0);
        Student normal2 = new Student("􏾽􏾾5号", 0);
        // 􏳋􏳌􏵕􏽩􏰈 VIP 􏴨􏳄􏳏􏳐􏸒􏵿􏵉􏵿
        PriorityQueue<Student> queue = new PriorityQueue<>((o1, o2) ->
                o2.getScore().compareTo(o1.getScore()));
        queue.add(vip1);
        queue.add(vip4);
        queue.add(vip3);
        queue.add(normal1);
        queue.add(normal2);
        queue.add(vip2);
        while (!queue.isEmpty()) {
            Student s1 = queue.poll();
            System.out.println(s1.getName() + "􏳏􏱞􏽷􏽸; " + "VIP􏴨􏳄: " + s1.getScore());
        }
    }


}
class Student implements Comparable<Student> {
    private String name;
    private Integer score;
    public Student(String name, Integer score) {
        this.name = name;
        this.score = score; }


    public Integer getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }
}
