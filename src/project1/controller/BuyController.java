package project1.controller;

import java.util.Map;
import project1.model.Item;

public class BuyController {
    private final Map<Item, Integer> orderMap;

    public BuyController(Map<Item, Integer> orderMap) {
        this.orderMap = orderMap;
    }


}
