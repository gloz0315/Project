package project1.application;

import project1.model.productList.Beer;
import project1.model.productList.Burgers;
import project1.model.productList.Fried;
import project1.model.productList.IceCream;
import project1.view.output.BeerMenuOutput;
import project1.view.output.BurgerMenuOutput;
import project1.view.output.FriedMenuOutput;
import project1.view.output.IceCreamMenuOutput;

public class Application {
    public static void main(String[] args) {
        Burgers burgers = new Burgers();
        burgers.initProductList();
        BurgerMenuOutput burgerMenuOutput = new BurgerMenuOutput(burgers);
        burgerMenuOutput.printMenu();

        IceCream iceCream = new IceCream();
        iceCream.initProductList();
        IceCreamMenuOutput iceCreamMenuOutput = new IceCreamMenuOutput(iceCream);
        iceCreamMenuOutput.printMenu();

        Fried fried = new Fried();
        fried.initProductList();
        FriedMenuOutput friedMenuOutput = new FriedMenuOutput(fried);
        friedMenuOutput.printMenu();

        Beer beer = new Beer();
        beer.initProductList();
        BeerMenuOutput beerMenuOutput = new BeerMenuOutput(beer);
        beerMenuOutput.printMenu();
    }
}
