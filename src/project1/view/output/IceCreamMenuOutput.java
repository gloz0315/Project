package project1.view.output;

import project1.model.productList.IceCream;

public class IceCreamMenuOutput implements MenuOutput{
    private IceCream iceCream;

    @Override
    public void setMenu(Object type) {
        iceCream = (IceCream) type;
    }

    @Override
    public void printMenu() {
        String format = "%d. %-15s | W %.1f | %s";
        System.out.println("아래 아이스크림 메뉴판을 보시고 상품을 골라 입력해주세요.\n");
        System.out.println("[ IceCream MENU ]");

        for(int i = 0; i < iceCream.products().size(); i++) {
            System.out.printf((format) + "%n",i+1,iceCream.products().get(i).getName(),
                    iceCream.products().get(i).itemPrice(), iceCream.products().get(i).getDescription());
        }
        System.out.println();
        System.out.println("0. 메뉴로 돌아가기\n");
    }
}
