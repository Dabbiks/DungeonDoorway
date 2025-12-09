package io.github.dabbiks.entities.heroes;

import io.github.dabbiks.entities.Entity;
import io.github.dabbiks.entities.components.HungerComponent;
import io.github.dabbiks.entities.components.SanityComponent;
import io.github.dabbiks.entities.components.StrengthComponent;

public abstract class Hero extends Entity {

    // * COMPONENTS
    public HungerComponent hunger;
    public SanityComponent sanity;
    public StrengthComponent strength;

    public Hero(String name, int spriteId) {
        super(name, spriteId);
    }

    public void enableHungerComponent(int max) {
        hunger = new HungerComponent(max);
    }

    public void enableSanityComponent(int max) {
        sanity = new SanityComponent(max);
    }

    public void enableStrengthComponent(int value) {
        strength = new StrengthComponent(value);
    }

}
