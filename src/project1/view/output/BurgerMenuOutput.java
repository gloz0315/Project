package project1.view.output;

import project1.model.productList.Burgers;

public class BurgerMenuOutput implements MenuOutput{
    private Burgers burgers;

    @Override
    public void setMenu(Object type) {
        burgers = (Burgers) type;
    }
}
