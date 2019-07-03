public class Main {

    public static void main(String[] args) {
        AbstractPlayer b = new Forwards("巴特尔");
        b.Attack();

        AbstractPlayer m = new Forwards("迈克尔");
        m.Attack();

        AbstractPlayer ym = new Translator("姚明");
        ym.Attack();
        ym.Defense();

    }
}
