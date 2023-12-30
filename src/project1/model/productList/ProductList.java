package project1.model.productList;

import java.util.List;
import project1.model.Item;

public interface ProductList {
    void initProductList();
    List<Item> products();
}
