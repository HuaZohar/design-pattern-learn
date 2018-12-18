package cn.hqlearn.proxy;

public class TankLogProxy implements Moveable {

    private Moveable tank;

    public TankLogProxy(Moveable tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        System.out.println("MOVE BEGIN...");
        tank.move();

        System.out.println("MOVE END...");
    }
}
