package io.github.dabbiks.entities;

public abstract class Entity {

    // * IDS
    public int entityId;
    public int spriteId;

    // * LOCATION
    public int x;
    public int y;

    // * STATS
    public int health;
    public int maxHealth;
    public int absorption;
    public int baseDamage;
    public int baseSpeed;

    // * STATUS EFFECTS
    public static final int POISONED = 0x001;
    public static final int IGNITED = 0x002;
    public static final int STUNNED = 0x004;

    private int status;

    public int getStatus() { return status; }

    public void addEffect(int effect) { status |= effect; }

    public void removeEffect(int effect) { status &= ~effect; }

    public boolean hasEffect(int effect) { return (status & effect) != 0; }

    public void toggleEffect(int effect) { status ^= effect; }

    public abstract void tick();

}
