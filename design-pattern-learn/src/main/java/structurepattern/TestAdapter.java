package structurepattern;


/**
 * 解释如下：
 * 1.adaptee 待适配的接口
 *
 * 2.target 要适配成什么样的接口
 *
 * 3.adapter 适配器 实现了target接口，并在实现的target接口中调用adaptee的接口（真正的接口）
 *
 */



/**
 * 目标接口：当前系统业务所期待的接口，它可以是抽象类或接口
 */
interface Target {
    void request();
}

/**
 * 适配者（Adaptee）类：它是被访问和适配的现存组件库中的组件接口
 */
class Adaptee {
    public void specificRequest() {
        System.out.println("适配者中的业务代码被调用！");
    }
}

/**
 * 对象适配器类：它是一个转换器，通过继承或引用适配者的对象，把适配者接口转换成目标接口，让客户按目标接口的格式访问适配者。
 */
class ObjectAdapter implements Target {

    private Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}


public class TestAdapter {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();

        final Target target = new ObjectAdapter(adaptee);

        target.request();
    }

}
