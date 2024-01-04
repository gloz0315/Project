package project1.controller;

// MainController는 메인메뉴에 관한 전반적인 흐름을 통제하는 곳이다.
// 주문과 어느 섹터(음식종류)로 갈 것인지 통제하는 클래스

import java.util.LinkedHashMap;
import java.util.Map;
import project1.model.Item;
import project1.model.MenuListInit;
import project1.model.productList.ProductList;
import project1.view.InputView;
import project1.view.output.MainMenuOutput;

public class MainController {
    private Map<Item,Integer> orderMap;                     // LinkedHashMap을 통해 주문 정보들을 순차적으로 처리
    private MainMenuOutput mainMenuOutput;                  // 메인 화면에서의 화면 Output 담당
    private MenuListInit menuListInit;                      // 종류별 음식들의 정보들을 초기화 해주는 클래스
    private ProductList productList;                        // 제품별 정보를 저장하는 인터페이스인 ProductList를 이용
    private MenuController menuController;                  // 특정 종류의 음식을 선택할 때 사용되는 로직을 담당하는 클래스
    private BuyController buyController;                    // 총 주문 정보들을 사려고 할때 처리하는 로직을 담당하는 클래스
    private CancelOrderController cancelOrderController;    // 진행중인 주문을 취소할 때 처리하는 로직을 담당하는 클래스
    private TotalSoldController totalSoldController;        // 총 판매한 정보들을 처리하는 로직을 담당하는 클래스

    public MainController() {
        orderMap = new LinkedHashMap<>();
        mainMenuOutput = new MainMenuOutput();
        menuListInit = new MenuListInit();
        menuController = new MenuController();
        totalSoldController = new TotalSoldController();
        buyController = new BuyController(orderMap, totalSoldController);
        cancelOrderController = new CancelOrderController(orderMap);
    }

    public void start() {
        while(true) {
            mainMenuOutput.welcomeStatement();
            mainMenuOutput.printMainMenu();
            String number = InputView.input();
            if(number.isEmpty()) {                      // null값으로 들어오면 예외
                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.\n");
                continue;
            }
            System.out.println();

            menuCase(Integer.parseInt(number));
        }
    }

    private void menuCase(int number) {
        switch (number) {
            case 1 -> productList = menuListInit.burgerMenu();
            case 2 -> productList = menuListInit.friedMenu();
            case 3 -> productList = menuListInit.iceCreamMenu();
            case 4 -> productList = menuListInit.beerMenu();
            case 5 -> {
                buyController.setDelayTime(3);          // 3초 정도 딜레이 타임을 가지도록 함
                buyController.buy();                    // 장바구니를 확인 후 주문
                return;
            }
            case 6 -> {
                cancelOrderController.cancelOrder(); // 주문취소
                return;
            }
            case 7 -> {
                totalSoldController.menuChoice(); // 총 판매 금액, 총 판매 내용에 대한 로직
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
}
