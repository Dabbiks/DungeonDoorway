package io.github.dabbiks.entities.components;

import com.badlogic.gdx.math.MathUtils;

public class SanityComponent {
    private int current;
    private int max;

    public SanityComponent(int max) {
        this.max = max;
        this.current = max;
    }

    public void add(int amount) {
        this.current = MathUtils.clamp(this.current - amount, 0, max);
    }

    public void subtract(int amount) {
        this.current = MathUtils.clamp(this.current + amount, 0, max);
    }
}
