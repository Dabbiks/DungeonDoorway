package io.github.dabbiks.entities.heroes;

import io.github.dabbiks.entities.Entity;
import io.github.dabbiks.entities.components.HealthComponent;
import io.github.dabbiks.entities.components.HungerComponent;
import io.github.dabbiks.entities.components.SanityComponent;
import io.github.dabbiks.entities.components.StrengthComponent;

public abstract class Hero extends Entity {

    public Hero(String name, int spriteId, int health, int hunger, int sanity) {
        super(name, spriteId);

        this.addComponent(new HealthComponent(health));
        this.addComponent(new HungerComponent(hunger));
        this.addComponent(new SanityComponent(sanity));
    }

}
