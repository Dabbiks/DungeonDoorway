package io.github.dabbiks.entities.components;

import com.badlogic.gdx.math.MathUtils;

public class HealthComponent {
    private int absorption;
    private int current;
    private int max;

    public HealthComponent(int max) {
        this.max = max;
        this.current = max;
    }

    // ! TODO ABSORPTION LOGIC
    public void damage(int amount) {
        this.current = MathUtils.clamp(this.current + absorption - amount, 0, max + absorption);
    }

    public void heal(int amount) {
        this.current = MathUtils.clamp(this.current + amount, 0, max);
    }

    public boolean isDead() {
        return current <= 0;
    }

    public float getPercentage() {
        return (float) current / max;
    }
}
