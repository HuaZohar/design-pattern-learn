package cn.hqlearn.proxy;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Tank tank = new Tank();
        TankLogProxy tankLogProxy = new TankLogProxy(tank);
        TankTimeProxy tankTimeProxy = new TankTimeProxy(tankLogProxy);
        tankTimeProxy.move();
    }
}
