package project1.view.output;

public class InitMenuOutput {
    private final BurgerMenuOutput burgerMenuOutput;
    private final BeerMenuOutput beerMenuOutput;
    private final FriedMenuOutput friedMenuOutput;
    private final IceCreamMenuOutput iceCreamMenuOutput;

    public InitMenuOutput() {
        burgerMenuOutput = new BurgerMenuOutput();
        beerMenuOutput = new BeerMenuOutput();
        friedMenuOutput = new FriedMenuOutput();
        iceCreamMenuOutput = new IceCreamMenuOutput();
    }

    public BurgerMenuOutput getBurgerMenuOutput() {
        return burgerMenuOutput;
    }

    public BeerMenuOutput getBeerMenuOutput() {
        return beerMenuOutput;
    }

    public FriedMenuOutput getFriedMenuOutput() {
        return friedMenuOutput;
    }

    public IceCreamMenuOutput getIceCreamMenuOutput() {
        return iceCreamMenuOutput;
    }
}
