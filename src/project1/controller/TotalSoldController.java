package project1.controller;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import project1.model.Item;
import project1.view.InputView;

// 총 판매된 정보들을 처리해주는 로직 클래스
public class TotalSoldController {
    private final Map<Item, Integer> totalSoldRepository;

    public TotalSoldController() {
        this.totalSoldRepository = new LinkedHashMap<>();
    }

    public void menuChoice() {
        printListChoice();
        insertNumber();
    }

    // 판매될 때의 내용을 저장소에 저장
    public void saveSoldItem(Map<Item,Integer> items) {
        for(Entry<Item,Integer> item : items.entrySet()) {
            Item item1 = new Item(item.getKey().getName(),item.getKey().getDescription(), item.getKey().itemPrice());
            Item inputItem = isContainItem(item1);

            if(inputItem == null) {
                totalSoldRepository.put(item1, item.getValue());
                return;
            }
            totalSoldRepository.replace(inputItem, totalSoldRepository.get(inputItem) + item.getValue());
        }
    }

    private void printListChoice() {
        System.out.println("[ Sold ]");
        System.out.println("어떤 것을 확인하시겠습니까?\n");
        System.out.println("1. 총 판매된 주문 목록   2. 총 판매된 금액  3. 메뉴판\n");
    }

    // 총 판매된 주문 목록에 대한 내용을 출력
    private void printSoldItemList() {
        System.out.println("[ 총 판매된 주문 목록 ]");
        System.out.println("현재까지 총 판매된 상품 목록은 아래와 같습니다.\n");
        String format = "- %-15s | W %.1f | %d 개\n";
        
        for(Entry<Item, Integer> items : totalSoldRepository.entrySet())
            System.out.printf((format),items.getKey().getName(), items.getKey().itemPrice(),items.getValue());
        System.out.println();
        backToMenu();
    }

    private void printSoldPrice() {
        System.out.println("[ 총 판매 금액 현황 ]");
        System.out.printf("현재까지 총 판매된 금액은 [ W %.1f ] 원 입니다.\n\n" ,calculateTotalPrice());
        backToMenu();
    }

    //
    private void insertNumber() {
        while(true) {
            String text = InputView.input();
            System.out.println();

            if(text.equals("1")) {
                printSoldItemList();
                break;
            } else if(text.equals("2")) {
                printSoldPrice();
                break;
            } else if(text.equals("3"))
                break;

            System.out.println("잘못 입력하셨습니다. \n");
        }
    }

    // 메뉴판으로 돌아가는 메서드
    private void backToMenu() {
        System.out.println("0. 메뉴판\n");
        while(true) {
            String number = InputView.input();

            if(number.equals("0"))
                return;

            System.out.println("잘못 입력하셨습니다.\n");
        }
    }

    private float calculateTotalPrice() {
        float totalPrice = 0.0f;

        for(Entry<Item, Integer> items : totalSoldRepository.entrySet()) {
            totalPrice += items.getKey().itemPrice() * items.getValue();
        }
        return totalPrice;
    }

    // totalSoldRepository에 해당 주문 아이템이 있는지 판단하는 메서드
    private Item isContainItem(Item item) {
        // return totalSoldRepository.containsKey(item); // containsKey는 equals()를 토대로 동작함. 따라서 하면 안됨 (주소값을 이용하니까)
        // 그래서 값 자체를 판단하게 로직을 변경
        String name = item.getName();
        float price = item.itemPrice();
        
        for(Entry<Item,Integer> repository : totalSoldRepository.entrySet()) {
            if(repository.getKey().getName().equals(name) && repository.getKey().itemPrice() == price)
                return repository.getKey();
        }
        return null;
    }
}
