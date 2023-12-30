package project1.view.output;

import project1.model.productList.Burgers;

public class BurgerMenuOutput {
    private Burgers burgers;

    public BurgerMenuOutput(Burgers burgers) {
        this.burgers = burgers;
    }

    public void printMenu() {
        String format = "%d. %-15s | W %.1f | %s";
        System.out.println("아래 버거메뉴판을 보시고 상품을 골라 입력해주세요.\n");
        System.out.println("[ Burgers MENU ]");

        for(int i = 0; i < burgers.products().size(); i++) {
            System.out.println(String.format(format,i+1,burgers.products().get(i).getName(),
                    burgers.products().get(i).itemPrice(), burgers.products().get(i).getDescription()));
        }
        System.out.println();
        System.out.println("0. 메뉴로 돌아가기\n");
    }
}
