package io.github.dabbiks.entities;

import io.github.dabbiks.entities.components.DamageComponent;
import io.github.dabbiks.entities.components.HealthComponent;
import io.github.dabbiks.entities.components.MovementComponent;

public abstract class Entity {

    // * IDS
    public int entityId;
    public int spriteId;

    // * LOCATION
    public int x;
    public int y;

    // * STATS
    public String name;
    public HealthComponent health;
    public DamageComponent damage;
    public MovementComponent movement;

    public Entity(String name, int spriteId) {
        this.name     = name;
        this.spriteId = spriteId;
    }

    public void enableHealthComponent (int max) { health = new HealthComponent(max); }

    public void enableDamageComponent () { damage = new DamageComponent(); }

    public void enableMovementComponent (int value) { movement = new MovementComponent(value); }

    // * STATUS EFFECTS
    public static final int POISONED = 0x001;
    public static final int IGNITED  = 0x002;
    public static final int STUNNED  = 0x004;

    private int status;

    public int getStatus()               { return status; }

    public void addEffect(int effect)    { status |= effect; }

    public void removeEffect(int effect) { status &= ~effect; }

    public boolean hasEffect(int effect) { return (status & effect) != 0; }

    public void toggleEffect(int effect) { status ^= effect; }

    // * LIFECYCLE
    public abstract void tick();

}
