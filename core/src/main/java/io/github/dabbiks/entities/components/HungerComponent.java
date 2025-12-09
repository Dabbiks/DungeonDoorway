package io.github.dabbiks.entities.components;

public class HungerComponent {
    private int current;
    private int max;

    public HungerComponent(int max) {
        this.max = max;
        this.current = max;
    }

    public void add(int amount) {
        this.current += amount;
    }

    public void subtract(int amount) {
        this.current -= amount;
    }
}
