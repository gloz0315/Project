package project1.view.output;

import project1.model.productList.IceCream;

public class IceCreamMenuOutput implements MenuOutput{
    private IceCream iceCream;

    @Override
    public void setMenu(Object type) {
        iceCream = (IceCream) type;
    }
}
