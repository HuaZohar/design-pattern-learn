package buildpattern.factorymethod;

public class TestAnimalFarm {

    public static void main(String[] args) {
        AnimalFarm animalFarm = (AnimalFarm) ReadXMLUtil.getObject();

        final Animal animal = animalFarm.newAnimal();
        animal.show();
    }
}

interface AnimalFarm{
    Animal newAnimal();
}

interface Animal{
    void show();
}

class Horse implements Animal{
    @Override
    public void show() {
        System.out.println("新马出生！");
    }
}

class Cattle implements Animal{

    @Override
    public void show() {
        System.out.println("新牛出生！");
    }
}

class HorseFarm implements AnimalFarm{

    @Override
    public Animal newAnimal() {
        return new Horse();
    }
}

class CattleFarm implements AnimalFarm{

    @Override
    public Animal newAnimal() {
        return new Cattle();
    }
}