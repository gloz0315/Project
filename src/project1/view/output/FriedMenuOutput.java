package project1.view.output;

import project1.model.productList.Fried;

public class FriedMenuOutput {
    private Fried fried;

    public FriedMenuOutput(Fried fried) {
        this.fried = fried;
    }

    public void printMenu() {
        String format = "%d. %-15s | W %.1f | %s";
        System.out.println("아래 감자튀김 메뉴판을 보시고 상품을 골라 입력해주세요.\n");
        System.out.println("[ Fried MENU ]");

        for(int i = 0; i < fried.products().size(); i++) {
            System.out.println(String.format(format,i+1,fried.products().get(i).getName(),
                    fried.products().get(i).itemPrice(), fried.products().get(i).getDescription()));
        }
        System.out.println();
        System.out.println("0. 메뉴로 돌아가기\n");
    }
}
