package project1.model;

import project1.model.productList.Beer;
import project1.model.productList.Burgers;
import project1.model.productList.Fried;
import project1.model.productList.IceCream;

// 이 클래스는 전체 음식 메뉴를 초기화하고 음식별로 정보를 넘겨주는 클래스이다.
public class MenuListInit {
    private Beer beer = new Beer();
    private Burgers burgers = new Burgers();
    private Fried fried = new Fried();
    private IceCream iceCream = new IceCream();

    public MenuListInit() {
        burgers.initProductList();
        beer.initProductList();
        fried.initProductList();
        iceCream.initProductList();
    }

    public Burgers burgerMenu() {
        return burgers;
    }

    public Beer beerMenu() {
        return beer;
    }

    public Fried friedMenu() {
        return fried;
    }

    public IceCream iceCreamMenu() {
        return iceCream;
    }
}
