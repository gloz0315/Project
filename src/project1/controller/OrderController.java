package project1.controller;

import project1.model.Item;
import project1.model.productList.ProductList;

// 장바구니에 대한 컨트롤러 클래스임.
public class OrderController {
    private ProductList productList;

    public void setProductList(ProductList productList) {
        this.productList = productList;
    }

    public Item choiceMenu(int number) {
        return productList.products().get(number-1);
    }

}
