package project1.model;

public class Item extends Menu{
    private final float price;

    public Item(String name, String description, float price) {
        super(name, description);
        this.price = price;
    }

    public float itemPrice() {
        return price;
    }
}
