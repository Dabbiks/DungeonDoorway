package io.github.dabbiks.entities;

import io.github.dabbiks.entities.components.Component;
import io.github.dabbiks.entities.components.DamageComponent;
import io.github.dabbiks.entities.components.HealthComponent;
import io.github.dabbiks.entities.components.MovementComponent;

import java.util.HashMap;
import java.util.Map;

public abstract class Entity {

    // * BASIC DATA
    private final String name;
    private int entityId;
    private int spriteId;

    // * LOCATION
    private int x;
    private int y;

    // * COMPONENTS
    private final Map<Class<? extends Component>, Component> components = new HashMap<>();

    // * STATUS EFFECTS
    public static final int POISONED = 0x001;
    public static final int IGNITED  = 0x002;
    public static final int STUNNED  = 0x004;

    private int status;

    public Entity(String name, int spriteId) {
        this.name     = name;
        this.spriteId = spriteId;
    }

    public <T extends Component> void addComponent(T component) {
        components.put(component.getClass(), component);
    }
    public <T extends Component> T getComponent(Class<T> type) {
        return type.cast(components.get(type));
    }
    public boolean hasComponent(Class<? extends Component> type) {
        return components.containsKey(type);
    }

    public int getStatus()               { return status; }
    public void addEffect(int effect)    { status |= effect; }
    public void removeEffect(int effect) { status &= ~effect; }
    public boolean hasEffect(int effect) { return (status & effect) != 0; }
    public void toggleEffect(int effect) { status ^= effect; }

    // * LIFECYCLE
    public abstract void tick();

}
