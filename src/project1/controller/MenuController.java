package project1.controller;

import java.util.Map;
import project1.model.Item;
import project1.model.productList.Beer;
import project1.model.productList.Burgers;
import project1.model.productList.Fried;
import project1.model.productList.IceCream;
import project1.model.productList.ProductList;
import project1.view.InputView;
import project1.view.output.BeerMenuOutput;
import project1.view.output.BurgerMenuOutput;
import project1.view.output.FriedMenuOutput;
import project1.view.output.IceCreamMenuOutput;
import project1.view.output.MenuOutput;

public class MenuController {
    private Map<Item,Integer> orderMap;
    private ProductList productList;
    private MenuOutput menuOutput;
    private OrderController orderController;

    public void setMenuController(ProductList productList, Map<Item,Integer> orderMap) {
        this.productList = productList;
        this.orderMap = orderMap;
        orderController = new OrderController();
    }

    public void printMenu() {
        if(productList instanceof Burgers) {
            menuOutput = new BurgerMenuOutput();
        } else if(productList instanceof Fried) {
            menuOutput = new FriedMenuOutput();
        } else if(productList instanceof IceCream) {
            menuOutput = new IceCreamMenuOutput();
        } else if(productList instanceof Beer) {
            menuOutput = new BeerMenuOutput();
        } else
            return;

        menuOutput.setMenu(productList);
        orderMenu();
    }

    public void orderMenu() {
        while(true) {
            menuOutput.printMenu();
            int number = Integer.parseInt(InputView.input());

            if(number == 0)
                break;

            orderController.setProductList(productList);
            Item item = orderController.choiceMenu(number);

            if(orderMap.containsKey(item)) {
                orderMap.replace(item, orderMap.get(item) + 1);
            } else {
                orderMap.put(item,1);
            }
        }
    }
}
