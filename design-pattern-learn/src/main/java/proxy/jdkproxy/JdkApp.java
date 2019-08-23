package proxy.jdkproxy;


/**
 * Hello world!
 */
public class JdkApp {
    public static void main(String[] args) {

        Tank tank = new Tank();

        InvocationHandler handler = new TimeHandler(tank);

        Moveable m = (Moveable) Proxy.newProxyInstance(Moveable.class, handler);

        m.move();

    }
}
