package io.github.dabbiks.entities.components;

import com.badlogic.gdx.math.MathUtils;

public class HealthComponent implements Component {
    private int max;
    private int current;
    private int absorption;

    public HealthComponent(int max) {
        this.max = max;
        this.current = max;
        this.absorption = 0;
    }

    public void setAbsorption(int amount) {
        this.absorption = amount;
    }

    public void damage(int amount) {
        int effectiveDamage = Math.max(0, amount - absorption);
        this.current = MathUtils.clamp(this.current - effectiveDamage, 0, max);
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

    public int getCurrent() { return current; }
}
