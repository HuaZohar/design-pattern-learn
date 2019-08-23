package buildpattern.abstractfactory;

import buildpattern.factorymethod.ReadXMLUtil;

/**
 * 抽象工厂
 */
public class TestAbstractFactory {
    public static void main(String[] args) {
        //Farm farm = new AFarm();
        Farm farm = new BFarm();

        final Animal animal = farm.newAnimal();
        animal.show();
        final Plant plant = farm.newPlant();
        plant.show();
    }
}

interface Animal {
    void show();
}

class Horse implements Animal {
    @Override
    public void show() {
        System.out.println("马儿");
    }
}

class Cattle implements Animal {

    @Override
    public void show() {
        System.out.println("牛儿");
    }
}

interface Plant {
    void show();
}

class Fruitage implements Plant {

    @Override
    public void show() {
        System.out.println("水果");
    }
}

class Vegetable implements Plant {

    @Override
    public void show() {
        System.out.println("蔬菜");
    }
}

interface Farm {
    Animal newAnimal();

    Plant newPlant();
}

class AFarm implements Farm {

    @Override
    public Animal newAnimal() {
        return new Horse();
    }

    @Override
    public Plant newPlant() {
        return new Vegetable();
    }
}

class BFarm implements Farm {

    @Override
    public Animal newAnimal() {
        return new Cattle();
    }

    @Override
    public Plant newPlant() {
        return new Fruitage();
    }
}
