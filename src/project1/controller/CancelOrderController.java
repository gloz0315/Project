package project1.controller;

import java.util.Map;
import project1.model.Item;
import project1.view.InputView;

// 주문 취소에 대한 컨트롤러 클래스 생성
public class CancelOrderController {
    private Map<Item,Integer> orderMap;

    public CancelOrderController(Map<Item, Integer> orderMap) {
        this.orderMap = orderMap;
    }

    // 전체 주문을 취소하는 메서드
    public void cancelOrder() {
        if(isEmpty()) {
            System.out.println("주문 내역이 없습니다. 메뉴화면으로 이동합니다.\n");
            return;
        }
        clearOrder();
    }

    private void printOrderCheck() {
        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 확인        2. 취소\n");
    }

    private boolean isEmpty() {
        return orderMap.isEmpty();
    }

    private void clearOrder() {
        while(true) {
            printOrderCheck();
            String text = InputView.input();

            if(text.equals("1")) {
                orderMap.clear();
                break;
            }
            else if(text.equals("2"))  {
                System.out.println("주문을 취소하셨습니다. 메뉴 화면으로 이동합니다.\n");
                break;
            }
            System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.\n");
        }
    }
}
