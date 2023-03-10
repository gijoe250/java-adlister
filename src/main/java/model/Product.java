package model;

public class Product {
    private String name;
    private int costInCents;

    public Product(String name, int costInCents) {
        this.name = name;
        this.costInCents = costInCents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCostInCents() {
        return costInCents;
    }

    public void setCostInCents(int costInCents) {
        this.costInCents = costInCents;
    }
}
