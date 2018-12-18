package cn.learn.jdkproxy;

import java.lang.reflect.Method;

public interface InvocationHandler {
    public void invoke(Object o, Method method);
}
