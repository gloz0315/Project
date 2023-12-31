package project1.controller;

// MainController는 메인메뉴에 관한 전반적인 흐름을 통제하는 곳이다.
// 주문과 어느 섹터(음식종류)로 갈 것인지 통제하는 클래스

import java.util.LinkedHashMap;
import java.util.Map;
import project1.model.Item;
import project1.view.InputView;
import project1.view.output.MainMenuOutput;

public class MainController {
    private Map<Item,Integer> orderMap; // LinkedHashMap을 통해 주문 정보들을 순차적으로 처리하자.
    private MainMenuOutput mainMenuOutput;

    public MainController() {
        orderMap = new LinkedHashMap<>();
        mainMenuOutput = new MainMenuOutput();
    }

    public void start() {
        int number = 0;

        while(number != 6) {
            mainMenuOutput.welcomeStatement();
            mainMenuOutput.printMainMenu();
            number = Integer.parseInt(InputView.input());
            menuCase(number);
        }
    }

    private void menuCase(int number) {
        switch(number) {
            case 1:
                break;

            case 2:
                break;

            case 3:
                break;

            case 4:
                break;

            case 5:
                break;

            case 6:
                break;
        }
    }
}
