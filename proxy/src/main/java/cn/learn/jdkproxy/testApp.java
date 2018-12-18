package cn.learn.jdkproxy;

import java.lang.reflect.Method;

public class testApp {

    public static void main(String[] args) {
        Method[] methods = Moveable.class.getMethods();
        for (Method method : methods) {
            System.out.println(method);
            System.out.println(method.getName());
        }
    }
}
