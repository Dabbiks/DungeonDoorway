package io.github.dabbiks.entities.heroes;

import io.github.dabbiks.entities.Entity;

public abstract class Hero extends Entity {

    // * STATS
    public int hunger;
    public int maxHunger;
    public int sanity;
    public int maxSanity;
    public int strength;

    public Hero(String name, int spriteId, int maxHealth, int baseDamage, int baseSpeed, int maxHunger, int maxSanity) {
        super(name, spriteId, maxHealth, baseDamage, baseSpeed);
        this.maxHunger = maxHunger;
        this.hunger    = maxHunger;
        this.maxSanity = maxSanity;
        this.sanity    = maxSanity;
        this.strength  = 5;
    }

}
