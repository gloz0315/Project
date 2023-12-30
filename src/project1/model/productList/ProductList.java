package project1.model.productList;

import java.util.ArrayList;
import java.util.List;
import project1.model.Item;

public interface ProductList {
    public void initProductList();
    public List<Item> products();
}
