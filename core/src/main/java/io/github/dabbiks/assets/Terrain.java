package io.github.dabbiks.assets;

public class Terrain {

    public static final int EMPTY = 0;
    public static final int FLOOR_STONE = 1;
    public static final int FLOOR_WOOD = 2;
    public static final int FLOOR_GRASS = 3;
    public static final int WALL_STONE = 4;
    public static final int WALL_WOOD = 5;
    public static final int DOOR = 6;
    public static final int WATER = 7;
    public static final int LAVA = 8;
    public static final int TRAP = 9;

    public static final int PASSABLE = 0x01;
    public static final int SOLID = 0x02;
    public static final int BLOCKS_SIGHT = 0x04;
    public static final int BURNABLE = 0x08;
    public static final int LIQUID = 0x10;
    public static final int HARMFUL = 0x20;
    public static final int INTERACTIVE = 0x40;

    public static final int[] tags = new int[256];

    static {
        tags[EMPTY] = SOLID | BLOCKS_SIGHT;

        tags[FLOOR_STONE] = PASSABLE;
        tags[FLOOR_WOOD] = PASSABLE | BURNABLE;
        tags[FLOOR_GRASS] = PASSABLE | BURNABLE;

        tags[WALL_STONE] = SOLID | BLOCKS_SIGHT;
        tags[WALL_WOOD] = SOLID | BLOCKS_SIGHT | BURNABLE;

        tags[DOOR] = SOLID | BLOCKS_SIGHT | BURNABLE | INTERACTIVE;

        tags[WATER] = PASSABLE | LIQUID;
        tags[LAVA] = PASSABLE | LIQUID | HARMFUL;
    }

    public static boolean isPassable(int tileID) {
        return (tags[tileID] & PASSABLE) != 0;
    }

    public static boolean isSolid(int tileID) {
        return (tags[tileID] & SOLID) != 0;
    }

    public static boolean isBurnable(int tileID) {
        return (tags[tileID] & BURNABLE) != 0;
    }

    public static boolean blocksSight(int tileID) {
        return (tags[tileID] & BLOCKS_SIGHT) != 0;
    }

    public static boolean isLiquid(int tileID) {
        return (tags[tileID] & LIQUID) != 0;
    }

}
