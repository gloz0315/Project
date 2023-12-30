package project1.view.output;

public class MainMenuOutput {

    public void welcomeStatement() {
        System.out.println("\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"");
    }

    public void printMainMenu() {
        String format = "%d. %-12s | %s";
        int number = printMenu(format);
        System.out.println();
        printOrderMenu(format, number);
        System.out.println();
    }

    private int printMenu(String format) {
        String[] menuNameList = {"Burgers","Fried","IceCream","Beer"};
        String[] menuDescription = {"앵거스 비프 통살은 다져만든 버거","매장에서 갖 튀긴 감자튀김","매장에서 직접 만든 음료","밖에서 산 맥주"};
        int number = 0;

        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n");
        System.out.println("[ SHAKESHACK MENU ]");
        for(int i = 0; i < menuNameList.length; i++) {
            System.out.println(String.format(format,i+1,menuNameList[i],menuDescription[i]));
            number = i+1;
        }

        return ++number;
    }

    private void printOrderMenu(String format, int nextNum) {
        String[] orderName = {"Order","Cancel"};
        String[] orderDescription = {"장바구니를 확인 후 주문합니다.", "진행중인 주문을 취소합니다."};
        int number = 0;

        System.out.println("[ ORDER MENU ]");
        for(int i = nextNum; i <= nextNum+1; i++) {
            System.out.println(String.format(format,i,orderName[number],orderDescription[number]));
            number++;
        }
    }
}
