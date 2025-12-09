package io.github.dabbiks.entities.components;

import com.badlogic.gdx.math.MathUtils;

public class ArmorComponent {
    private int current;

    public void add(int amount) {
        this.current += amount;
    }

    public void subtract(int amount) {
        this.current -= amount;
    }
}
