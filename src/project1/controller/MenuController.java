package project1.controller;

import java.util.Map;
import project1.model.Item;
import project1.model.productList.Beer;
import project1.model.productList.Burgers;
import project1.model.productList.Fried;
import project1.model.productList.IceCream;
import project1.model.productList.ProductList;
import project1.view.InputView;
import project1.view.output.InitMenuOutput;
import project1.view.output.MenuOutput;

public class MenuController {
    private Map<Item,Integer> orderMap;
    private ProductList productList;
    private MenuOutput menuOutput;
    private OrderController orderController;
    private InitMenuOutput initMenuOutput;

    public void setMenuController(ProductList productList, Map<Item,Integer> orderMap) {
        this.productList = productList;
        this.orderMap = orderMap;
        orderController = new OrderController();
        initMenuOutput = new InitMenuOutput();
    }

    // 특정 메뉴의 정보를 출력하는 메서드
    public void printMenu() {
        menuOutput = selectMenuOutput();
        menuOutput.setMenu(productList);
        selectMenu();
    }

    // menuOutput에 대한 타입을 지정해줌
    private MenuOutput selectMenuOutput() {
        if(productList instanceof Burgers) {
            return initMenuOutput.getBurgerMenuOutput();
        } else if(productList instanceof Fried) {
            return initMenuOutput.getFriedMenuOutput();
        } else if(productList instanceof IceCream) {
            return initMenuOutput.getIceCreamMenuOutput();
        } else if(productList instanceof Beer) {
            return initMenuOutput.getBeerMenuOutput();
        }

        // 해당 타입이 아니라면 예외처리가 발생해야하지만 이미 Main에서 막아주기 때문에 굳이 설정 안해도 될듯
        return null;
    }

    // 메뉴를 고르는 메서드
    private void selectMenu() {
        while(true) {
            menuOutput.printMenu();

            int number = checkNumber();
            System.out.println();

            if(number == 0)
                break;
            else if(number == -1) {
                System.out.println("숫자를 잘못 입력하셨습니다. 다시 입력해주세요.\n");
                continue;
            }

            if(productList.products().size() < number || number < 0) {
                System.out.println("숫자를 잘못 입력하셨습니다. 다시 입력해주세요.\n");
                continue;
            }
            orderController.setProductList(productList);
            orderMenu(typeOrderMenu(number));
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
        String format = "%-20s | W %.1f | %s";
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

    // 입력 숫자값이 null값인지 체크해주는 메서드
    private int checkNumber() {
        String number = InputView.input();

        if(number.isEmpty())
            return -1;

        return Integer.parseInt(number);
    }

    private Item itemInfo(int number) {
        return orderController.choiceMenu(number);
    }

    // Single타입인지 Double타입인지 메뉴를 골라주는 메서드
    private Item typeOrderMenu(int number) {
        Item item = itemInfo(number);
        String format =  "%-20s | W %.1f | %s\n";

        while(true) {
            System.out.printf((format),item.getName(),item.itemPrice(),item.getDescription());
            System.out.println("위 메뉴의 어떤 옵션으로 추가하시겠습니까?");
            System.out.printf("1. Single(W %.1f)      2. Double(W %.1f)\n\n", item.itemPrice(), item.itemPrice() + 3.0f);

            String text = InputView.input();

            if(text.equals("1"))
                return item;
            else if(text.equals("2")) {
                return orderController.choiceDoubleMenu(number);
            }
            System.out.println("잘못 누르셨습니다. 다시 눌러주세요.\n");
        }
    }
}
