package io.github.dabbiks.items;

public abstract class Item {

    // * IDS
    public int spriteId;

    // * STATS
    public String name;
    public int value;
    public int count;
    public int maxCount;

    public Item(String name, int spriteId, int value, int maxCount) {
        this.name = name;
        this.spriteId = spriteId;
        this.value = value;
        this.maxCount = maxCount;
        this.count = 1;
    }

}
