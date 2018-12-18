package cn.learn.jdkproxy;

import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler {

    private Object target;

    public TimeHandler(Object target) {
        this.target = target;
    }

    @Override
    public void invoke(Object o, Method method) {

        long startTime = System.currentTimeMillis();
        System.out.println("BEGIN TIME : " + startTime);

        try {
            method.invoke(target, new Object[]{});
        } catch (Exception e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("END TIME : " + endTime + " , COST TIME : " + (endTime - startTime));
    }
}
