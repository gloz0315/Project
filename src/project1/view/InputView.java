package project1.view;

import project1.console.Console;

public class InputView {

    private InputView() {
        // 생성자를 막음으로서 인스턴스 생성을 막음 (결국에 static 메서드만 잇으니까)
    }

    public static String input() {
        System.out.print("번호를 입력하세요 > ");
        return Console.readLine();
    }
}
