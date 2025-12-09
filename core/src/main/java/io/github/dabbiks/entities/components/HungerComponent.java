package io.github.dabbiks.entities.components;

public class HungerComponent implements Component {
    private int current;
    private int max;

    public HungerComponent(int max) {
        this.max = max;
        this.current = max;
    }

    public void eat(int amount) {
        this.current = Math.min(this.current + amount, max);
    }

    public void starve(int amount) {
        this.current = Math.max(this.current - amount, 0);
    }
}
