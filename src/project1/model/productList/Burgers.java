package project1.model.productList;

import java.util.ArrayList;
import java.util.List;
import project1.model.Item;

public class Burgers implements ProductList {
    private final List<Item> productList = new ArrayList<>();
    private final List<Item> doubleProductList = new ArrayList<>();

    @Override
    public void initProductList() {
        productList.add(new Item("ShackBurger","토마토, 양상추, 쉑소스가 토핑된 치즈버거",6.9f));
        productList.add(new Item("SmokeShack","베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거",8.9f));
        productList.add(new Item("Shroom Burger","몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거",9.4f));
        productList.add(new Item("Cheese Burger", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거",6.9f));
        productList.add(new Item("Hamburger", "비프패티를 기반으로 야채가 들어간 기본버거",5.4f));
        initDoubleProductList();
    }

    public void initDoubleProductList() {
        for(Item item : productList) {
            doubleProductList.add(new Item(item.getName() + "(Double)", item.getDescription(), item.itemPrice()+ 3.0f));
        }
    }

    @Override
    public List<Item> products() {
        return productList;
    }

    @Override
    public List<Item> doubleProducts() {
        return doubleProductList;
    }
}
