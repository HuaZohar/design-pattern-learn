package proxy.staticproxy;

public class TankTimeProxy implements Moveable {

    private Moveable tank;

    public TankTimeProxy(Moveable tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        long startTime = System.currentTimeMillis();
        System.out.println("BEGIN TIME : " + startTime);
        tank.move();

        long endTime = System.currentTimeMillis();
        System.out.println("END TIME : " + endTime + " , COST TIME : " + (endTime - startTime));
    }
}
