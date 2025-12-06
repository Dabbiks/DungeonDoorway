package io.github.dabbiks.entities;

public class Status {

    public static final int POISONED = 0x001;
    public static final int IGNITED = 0x002;
    public static final int STUNNED = 0x004;

    public int addEffect(int entityStatus, int effect) {
        return entityStatus |= effect;
    }

    public int removeEffect(int entityStatus, int effect) {
        return entityStatus &= ~effect;
    }

    public boolean hasEffect(int entityStatus, int effect) {
        return (entityStatus & effect) != 0;
    }

    public int toggleEffect(int entityStatus, int effect) {
        return entityStatus ^= effect;
    }

}
