package structurepattern;

/**
 * 解释如下：
 * 1.adaptee 待适配的接口
 * <p>
 * 2.target 要适配成什么样的接口
 * <p>
 * 3.adapter 适配器 实现了target接口，并在实现的target接口中调用adaptee的接口（真正的接口）
 */

/**
 * target  要适配成什么样子
 */
interface Motor {
    void driver();
}

/**
 * 待适配的接口
 */
class ElectricMotor {
    public void electricDriver() {
        System.out.println("ElectricMotor...electricDriver...");
    }
}

/**
 * 适配器：实现target接口，并调用待适配的接口
 */
class ElectricAdapter implements Motor {

    private ElectricMotor electricMotor;

    public ElectricAdapter() {
        this.electricMotor = new ElectricMotor();
    }

    @Override
    public void driver() {
        electricMotor.electricDriver();
    }
}


class OpticalMotor {
    public void opticalDriver() {
        System.out.println("OpticalMotor...opticalDriver...");
    }
}

class OpticalAdapter implements Motor{

    private OpticalMotor opticalMotor;

    public OpticalAdapter() {
        this.opticalMotor = new OpticalMotor();
    }

    @Override
    public void driver() {
        opticalMotor.opticalDriver();
    }
}


public class TestAdapterExample01 {

    public static void main(String[] args) {

        Motor motor = new ElectricAdapter();
        motor.driver();


        final Motor motor1 = new OpticalAdapter();
        motor1.driver();
    }

}
