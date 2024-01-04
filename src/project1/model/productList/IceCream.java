package project1.model.productList;

import java.util.ArrayList;
import java.util.List;
import project1.model.Item;

public class IceCream implements ProductList{
    private final List<Item> productList = new ArrayList<>();
    private final List<Item> doubleProductList = new ArrayList<>();

    @Override
    public void initProductList() {
        productList.add(new Item("Chocolate Ice","초코 시럽이 듬뿍 들어간 아이스크림",3.5f));
        productList.add(new Item("Vanilla Ice","바닐라 향이 진한 아이스크림",3.0f));
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
