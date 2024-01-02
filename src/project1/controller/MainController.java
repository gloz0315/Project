package project1.controller;

// MainController는 메인메뉴에 관한 전반적인 흐름을 통제하는 곳이다.
// 주문과 어느 섹터(음식종류)로 갈 것인지 통제하는 클래스

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import project1.model.Item;
import project1.model.MenuListInit;
import project1.model.productList.ProductList;
import project1.view.InputView;
import project1.view.output.MainMenuOutput;

public class MainController {
    private Map<Item,Integer> orderMap;     // LinkedHashMap을 통해 주문 정보들을 순차적으로 처리하자.
    private MainMenuOutput mainMenuOutput;  // 메인 화면에서의 화면 Output 담당
    private MenuListInit menuListInit;      // 종류별 음식들의 정보들을 초기화 해주는 클래스
    private ProductList productList;        // 제품별 정보를 저장하는 인터페이스인 ProductList를 이용할 것임
    private MenuController menuController;  // 특정 종류의 음식을 선택할 때 사용되는 로직을 담당하는 클래스
    private BuyController buyController;    // 총 주문 정보들을 사려고 할때 처리하는 로직을 담당하는 클래스

    public MainController() {
        orderMap = new LinkedHashMap<>();
        mainMenuOutput = new MainMenuOutput();
        menuListInit = new MenuListInit();
        menuController = new MenuController();
        buyController = new BuyController(orderMap);
    }

    public void start() {
        while(true) {
            mainMenuOutput.welcomeStatement();
            mainMenuOutput.printMainMenu();
            int number = Integer.parseInt(InputView.input());
            System.out.println();

            menuCase(number);
        }
    }

    private void menuCase(int number) {
        switch (number) {
            case 1 ->
                    productList = menuListInit.burgerMenu();
            case 2 ->
                    productList = menuListInit.friedMenu();
            case 3 ->
                    productList = menuListInit.iceCreamMenu();
            case 4 ->
                    productList = menuListInit.beerMenu();
            case 5 -> {         // 주문 버튼 (이거는 하나의 컨트롤러 클래스를 따로 정리해서 만들어야겠다.)
                printBuyList();
                return;
            }
            case 6 -> {         // 주문취소  -> 추가적으로 만들어야 할 상황 (주문 취소 버튼의 재확인, 어떤 주문을 취소할 것인지 로직 구현)
                clearOrderMenu();
                return;
            }
            default -> {
                System.out.println("숫자를 잘못 입력하셨습니다. 다시 입력해주세요.\n");
                return;
            }
        }
        getMenuController();
    }
    
    // 음식 섹터별, 로직을 수행하게 될 menuController 호출
    private void getMenuController() {
        menuController.setMenuController(productList, orderMap);        // 음식 종류의 타입과 주문 정보 데이터를 넘긴다.
        menuController.printMenu();
        System.out.println();
    }

    // 장바구니에 대한 정보 출력
    private void printBuyList() {
        float total = 0.0f;
        System.out.println("다음과 같이 주문하시겠습니까?\n\n");

        System.out.println("[ Orders ]");
        for(Entry<Item,Integer> items : orderMap.entrySet()) {
            System.out.println("음식 이름:" + items.getKey().getName() + " 음식 가격:" + items.getKey().itemPrice()
             + " 음식 설명:" + items.getKey().getDescription());
            total += items.getKey().itemPrice();
        }

        System.out.println();
        System.out.println("[ Total ] ");
        System.out.println("W " + total + "\n");
        System.out.println("1. 주문     2. 메뉴판");
    }
    
    // 장바구니에 대한 정보들을 다 삭제할 것인지에 대한 메서드
    private void clearOrderMenu() {
        if(isClearOrder()) {
            orderMap.clear();           // orderMap에 대한 정보들을 다 제거
            System.out.println("모든 주문이 취소되었습니다.\n");
        }

    }

    private boolean isClearOrder() {
        while(true) {
            System.out.println("주문을 취소 하시겠습니까?");
            System.out.println("1. 확인       2. 취소");
            String text = InputView.input();
            System.out.println();

            if(text.equals("1"))
                return true;
            else if(text.equals("2"))
                return false;
        }
    }
}
