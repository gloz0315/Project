package project1.view.output;

import project1.model.productList.ProductList;

public interface MenuOutput {
    void setMenu(Object type);
    default void printMenu(ProductList productList, String[] names) {
        String format = "%d. %-20s | W %.1f | %s";
        System.out.printf("아래 %s 메뉴판을 보시고 상품을 골라 입력해주세요.\n\n",names[0]);
        System.out.printf("[ %s MENU ]\n", names[1]);

        for(int i = 0; i < productList.products().size(); i++) {
            System.out.printf((format) + "%n",i+1,productList.products().get(i).getName(),
                    productList.products().get(i).itemPrice(), productList.products().get(i).getDescription());
        }
        System.out.println();
        System.out.println("0. 메뉴로 돌아가기\n");
    }
}
