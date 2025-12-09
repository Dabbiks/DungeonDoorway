package io.github.dabbiks.entities.components;

public class DamageComponent {
    private int current;

    public void add(int amount) {
        this.current += amount;
    }

    public void subtract(int amount) {
        this.current -= amount;
    }
}
