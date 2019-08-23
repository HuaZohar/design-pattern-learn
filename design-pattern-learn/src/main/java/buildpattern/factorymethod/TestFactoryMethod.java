package buildpattern.factorymethod;

/**
 * 工厂方法
 */
public class TestFactoryMethod {

    public static void main(String[] args) {
        final AbstractFactory factory = (AbstractFactory) ReadXMLUtil.getObject();
        final Product product = factory.newProduct();
        product.show();
    }

}

/**
 * 产品
 */
interface Product {
    void show();
}

class Product1 implements Product {
    @Override
    public void show() {
        System.out.println("产品1");
    }
}

class Product2 implements Product {
    @Override
    public void show() {
        System.out.println("产品2");
    }
}

/**
 * 产品工厂
 */
interface AbstractFactory {
    Product newProduct();
}

class ConcreteFactory1 implements AbstractFactory {

    @Override
    public Product newProduct() {
        return new Product1();
    }
}

class ConcreteFactory2 implements AbstractFactory {

    @Override
    public Product newProduct() {
        return new Product2();
    }
}