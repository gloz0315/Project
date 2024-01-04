package project1.view.output;

import project1.model.productList.Beer;

public class BeerMenuOutput implements MenuOutput{
    private Beer beer;

    @Override
    public void setMenu(Object type) {
        beer = (Beer) type;
    }
}
