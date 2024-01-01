package project1.view.output;

import project1.model.productList.Fried;

public class FriedMenuOutput implements MenuOutput{
    private Fried fried;

    @Override
    public void setMenu(Object type) {
        fried = (Fried) type;
    }

    @Override
    public void printMenu() {
        String format = "%d. %-15s | W %.1f | %s";
        System.out.println("아래 감자튀김 메뉴판을 보시고 상품을 골라 입력해주세요.\n");
        System.out.println("[ Fried MENU ]");

        for(int i = 0; i < fried.products().size(); i++) {
            System.out.printf((format) + "%n",i+1,fried.products().get(i).getName(),
                    fried.products().get(i).itemPrice(), fried.products().get(i).getDescription());
        }
        System.out.println();
        System.out.println("0. 메뉴로 돌아가기\n");
    }
}
