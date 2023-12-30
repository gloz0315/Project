package project1.model.productList;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import project1.model.Item;

class BurgersTest {

    @Test
    @DisplayName("버거 음식 종류 갯수 확인")
    public void 개수확인() {
        Burgers burgers = new Burgers();
        burgers.initProductList();
        List<Item> burgerMenu = new ArrayList<>();

        burgerMenu = burgers.products();

        Assertions.assertEquals(burgerMenu.size(),5);
    }

}