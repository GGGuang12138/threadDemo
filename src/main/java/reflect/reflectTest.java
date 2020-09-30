package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * 代理+抽象工厂模式
 * Creat by GG
 * Date on 2020/9/29  3:14 下午
 */
public class reflectTest {
    public static Map<Integer,Integer> getMap(String className) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Class.forName(className);
        Constructor constructor = clazz.getConstructor();
        return (Map<Integer, Integer>) constructor.newInstance();
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        HashMap<Integer,Integer> map = (HashMap<Integer, Integer>) getMap("java.util.HashMap");
        map.put(123,123);
        System.out.println(map.get(123));
    }
}
