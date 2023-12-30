package project1.view.output;

import project1.model.productList.Beer;

public class BeerMenuOutput {
    private Beer beer;

    public BeerMenuOutput(Beer beer) {
        this.beer = beer;
    }

    public void printMenu() {
        String format = "%d. %-15s | W %.1f | %s";
        System.out.println("아래 주류 메뉴판 보시고 상품을 골라 입력해주세요.\n");
        System.out.println("[ Beer MENU ]");

        for(int i = 0; i < beer.products().size(); i++) {
            System.out.println(String.format(format,i+1,beer.products().get(i).getName(),
                    beer.products().get(i).itemPrice(), beer.products().get(i).getDescription()));
        }
        System.out.println();
        System.out.println("0. 메뉴로 돌아가기\n");
    }
}
