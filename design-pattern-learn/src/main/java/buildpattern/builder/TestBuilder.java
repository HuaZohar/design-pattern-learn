package buildpattern.builder;

/**
 * 建造者
 */
public class TestBuilder {
    public static void main(String[] args) {

    }
}

/**
 * 产品
 */
class Parlour {
    private String wall;  //墙
    private String TV;    //电视
    private String sofa;  //沙发

    public void setWall(String wall) {
        this.wall = wall;
    }

    public void setTV(String TV) {
        this.TV = TV;
    }

    public void setSofa(String sofa) {
        this.sofa = sofa;
    }

    public void show() {
        System.out.println(this.wall + "," + this.TV + "," + this.sofa);
    }
}


/**
 * 抽象建造者：装修工人
 */
abstract class Decorator {
    //创建产品对象
    protected Parlour product = new Parlour();
    public abstract void buildWall();
    public abstract void buildTV();
    public abstract void buildSofa();
    //返回产品对象
    public Parlour getResult() {
        return product;
    }
}

