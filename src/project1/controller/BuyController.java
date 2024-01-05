package project1.controller;

import java.util.Map;
import java.util.Map.Entry;
import project1.model.Item;
import project1.view.InputView;

// 주문 정보에 대한 내용에서 주문 내용을 구매할 것인지, 취소할 것인지에 대한 로직을 처리하는 클래스
public class BuyController {
    private final Map<Item, Integer> orderMap;
    private final TotalSoldController totalSoldController;              // 주문 정보들을 다 저장하게 된다면 주문 저장소에 값을 넣어야함
    private int sequence;
    private int delayTime;

    public BuyController(Map<Item, Integer> orderMap, TotalSoldController totalSoldController) {
        this.orderMap = orderMap;
        this.totalSoldController = totalSoldController;
        sequence = 0;
    }

    public void buy() {
        if(orderMap.isEmpty()) {
            System.out.println("주문 내역이 없습니다. 메뉴판으로 이동합니다.\n");
            return;
        }

        buyList();
        printTotalPrice();
        orderChoice();
        System.out.println();
    }

    public void setDelayTime(int delayTime) {
        this.delayTime = delayTime;
    }

    private void buyList() {
        System.out.println("다음과 같이 주문하시겠습니까?\n");
        printMenuList();
    }

    private void printTotalPrice() {
        System.out.println("[ Total ]");
        System.out.printf("W %.1f \n\n", totalPrice());
    }

    private void orderChoice() {
        while(true) {
            System.out.println("1. 주문      2. 메뉴판\n");
            String number = InputView.input();

            if(number.equals("1")) {
                orderSuccess();
                return;
            } else if (number.equals("2")) {
                System.out.println();
                return;
            }
            System.out.println("잘못 입력하셨습니다. 다시 눌러주세요.\n");
        }
    }

    private void orderSuccess(){
        System.out.println("\n주문이 완료되었습니다.!\n");
        System.out.printf("대기번호는 [ %d ]번 입니다.\n",++sequence);
        System.out.printf("(%d초후 메뉴판으로 돌아갑니다.)\n", delayTime);
        totalSoldController.saveSoldItem(orderMap);         // 주문 완료된 정보들을 따로 저장
        delayTimeMethod(delayTime);
        orderMap.clear();
    }
    
    private void printMenuList() {
        System.out.println("[ Orders ]");
        String format = "%-20s | W %.1f | %d 개 | %s\n";     // 주문 갯수 포함
        for(Entry<Item,Integer> items : orderMap.entrySet()) {
            System.out.printf((format),items.getKey().getName(), items.getKey().itemPrice(),items.getValue()
                    ,items.getKey().getDescription());
        }
        System.out.println();
    }

    private float totalPrice() {
        float totalPrice = 0.0f;

        for(Entry<Item,Integer> items : orderMap.entrySet()) {
            totalPrice += items.getKey().itemPrice() * items.getValue();
        }

        return totalPrice;
    }

    private void delayTimeMethod(int delayTime) {
        try {
            int time = delayTime * 1000;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
