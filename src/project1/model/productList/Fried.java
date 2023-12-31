package project1.model.productList;

import java.util.ArrayList;
import java.util.List;
import project1.model.Item;

public class Fried implements ProductList{
    private final List<Item> productList = new ArrayList<>();

    @Override
    public void initProductList() {
        productList.add(new Item("Cheese Fried","치즈가 잔뜩 들어간 감자튀김",4.5f));
        productList.add(new Item("Fried","짭짤한 맛이 일품인 감자튀김",3.8f));
    }

    @Override
    public List<Item> products() {
        return productList;
    }
}
