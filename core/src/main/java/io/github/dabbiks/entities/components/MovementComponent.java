package io.github.dabbiks.entities.components;

public class MovementComponent {
    private int current;

    public MovementComponent(int value) {
        this.current = value;
    }

    public void add(int amount) {
        this.current += amount;
    }

    public void subtract(int amount) {
        this.current -= amount;
    }
}
