package project1.view;

import project1.console.Console;

public class InputView {

    public static String input() {
        System.out.print("번호를 입력하세요 > ");
        return Console.readLine();
    }
}
