package actionpattern;

/**
 * 策略模式
 */
public class TestStrategy {

    public static void main(String[] args) {
        Context context = new Context();
        Strategy strategy = new ConcreteStrategyB();
        context.setStrategy(strategy);
        strategy.strategyMethod();
    }
}

interface Strategy {
    void strategyMethod();    //策略方法
}

class ConcreteStrategyA implements Strategy {

    @Override
    public void strategyMethod() {
        System.out.println("ConcreteStrategyA");
    }
}

class ConcreteStrategyB implements Strategy {

    @Override
    public void strategyMethod() {
        System.out.println("ConcreteStrategyB");
    }
}

class Context {
    private Strategy strategy;

    public void strategyMethod() {
        strategy.strategyMethod();
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}

