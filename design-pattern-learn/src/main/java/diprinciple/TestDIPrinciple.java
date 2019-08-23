package diprinciple;

/**
 * 依赖倒置原则
 */
public class TestDIPrinciple {

    public static void main(String[] args) {
        Customer customer = new Customer();
        System.out.println("顾客购买以下商品：");
        customer.shopping(new ShaoguanShop());
        customer.shopping(new WuyuanShop());
    }

}

interface Shop{
    String sell();
}

class ShaoguanShop implements Shop{

    @Override
    public String sell() {
        return "韶关特产：香菇，木耳...";
    }
}

class WuyuanShop implements Shop{

    @Override
    public String sell() {
        return "婺源特产：绿茶，酒糟鱼...";
    }
}

class Customer{
    public void shopping(Shop shop){
        System.out.println(shop.sell());
    }
}