package project1.view.output;

import project1.model.productList.Fried;

public class FriedMenuOutput implements MenuOutput{
    private Fried fried;

    @Override
    public void setMenu(Object type) {
        fried = (Fried) type;
    }

}
