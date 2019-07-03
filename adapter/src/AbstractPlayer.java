public abstract class AbstractPlayer {
    protected String name;

    public AbstractPlayer(String name) {
        this.name = name;
    }

    public abstract void Attack();

    public abstract void Defense();
}
