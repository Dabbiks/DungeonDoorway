package io.github.dabbiks.entities.components;

public class StrengthComponent {
    private int current;

    public StrengthComponent(int value) {
        this.current = value;
    }

    public void add(int amount) {
        this.current += amount;
    }

    public void subtract(int amount) {
        this.current -= amount;
    }
}
