package se411_lab3;

public class NumberBox<T extends Number> {

    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public double sum(Number other) {
        return item.doubleValue() + other.doubleValue();
    }
}