package project1.model.productList;

import java.util.ArrayList;
import java.util.List;
import project1.model.Item;

public class Beer implements ProductList{
    private final List<Item> productList = new ArrayList<>();
    private final List<Item> doubleProductList = new ArrayList<>();

    @Override
    public void initProductList() {
        productList.add(new Item("Cass","대표적인 맥주",4.5f));
        productList.add(new Item("Hite","상쾌한 맥주",4.5f));
        productList.add(new Item("Giesinger","뭐인지 모르는 맥주",6.5f));
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
