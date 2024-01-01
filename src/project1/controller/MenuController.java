package project1.controller;

import java.util.Map;
import project1.model.Item;
import project1.model.productList.Beer;
import project1.model.productList.Burgers;
import project1.model.productList.Fried;
import project1.model.productList.IceCream;
import project1.model.productList.ProductList;
import project1.view.InputView;
import project1.view.output.BeerMenuOutput;
import project1.view.output.BurgerMenuOutput;
import project1.view.output.FriedMenuOutput;
import project1.view.output.IceCreamMenuOutput;
import project1.view.output.MenuOutput;

public class MenuController {
    private Map<Item,Integer> orderMap;
    private ProductList productList;
    private MenuOutput menuOutput;
    private OrderController orderController;

    public void setMenuController(ProductList productList, Map<Item,Integer> orderMap) {
        this.productList = productList;
        this.orderMap = orderMap;
        orderController = new OrderController();
    }

    public void printMenu() {
        if(productList instanceof Burgers) {
            menuOutput = new BurgerMenuOutput();
        } else if(productList instanceof Fried) {
            menuOutput = new FriedMenuOutput();
        } else if(productList instanceof IceCream) {
            menuOutput = new IceCreamMenuOutput();
        } else if(productList instanceof Beer) {
            menuOutput = new BeerMenuOutput();
        } 
        
        // 해당 타입이 아니라면 예외처리가 발생해야하지만 이미 Main에서 막아주기 때문에 굳이 설정 안해도 될듯

        menuOutput.setMenu(productList);
        selectMenu();
    }

    public void selectMenu() {
        while(true) {
            menuOutput.printMenu();
            int number = Integer.parseInt(InputView.input());
            System.out.println();

            if(number == 0)
                break;

            // 메뉴를 고르는데 숫자 번호가 없을 경우 예외 발생
            if(productList.products().size() < number || number < 0) {
                System.out.println("숫자를 잘못 입력하셨습니다. 다시 입력해주세요.\n");
                continue;
            }
            orderController.setProductList(productList);
            Item item = orderController.choiceMenu(number);     // 아이템 정보를 넘겨줌
            orderMenu(item);
        }
    }

    // 메뉴를 장바구니에 넣을 것인지 선택하는 메서드
    private void orderMenu(Item item) {
        menuInformation(item);
        int number = Integer.parseInt(InputView.input());
        System.out.println();

        if(number == 1) {
            insertMenu(item);
            System.out.println(item.getName() + " 가 장바구니에 추가되었습니다.\n");
            return;
        } else if(number == 2)
            return;

        System.out.println("숫자를 잘못 입력하셨습니다. 상품으로 메뉴가 넘어갑니다.\n");
    }

    // 메뉴 정보가 출력된 후, 추가할 것인지 확인해주는 메서드
    private void menuInformation(Item item) {
        String format = "%-15s | W %.1f | %s";
        System.out.printf((format) + "%n",item.getName(),item.itemPrice(),item.getDescription());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소\n");
    }

    // 아이템 메뉴를 장바구니에 넣는 메서드
    private void insertMenu(Item item) {
        if(orderMap.containsKey(item)) {
            orderMap.replace(item, orderMap.get(item) + 1);
            return;
        }
        orderMap.put(item,1);
    }
}
