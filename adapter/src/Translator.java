public class Translator extends AbstractPlayer {

    private ForeignCenter foreignCenter = new ForeignCenter();

    public Translator(String name) {
        super(name);
        foreignCenter.setName(name);
    }

    @Override
    public void Attack() {
        foreignCenter.进攻();
    }

    @Override
    public void Defense() {
        foreignCenter.防守();
    }
}
