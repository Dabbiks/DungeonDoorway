package io.github.dabbiks.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;

import static io.github.dabbiks.assets.Bitmask.LEFT;
import static io.github.dabbiks.assets.Bitmask.TOP;

public class DungeonAssets implements Disposable {

    private TextureAtlas atlas;
    private TextureRegion errorTexture;

    private final TextureRegion[] stoneWalls = new TextureRegion[Bitmask.COMBINATIONS];
    private final Array<TextureRegion> stoneFloors = new Array<>();
    private final Array<TextureRegion> woodenFloors = new Array<>();

    public TextureRegion verticalDoorClosed, verticalDoorOpen;
    public TextureRegion horizontalDoorClosed, horizontalDoorOpen;

    public void load() {
        atlas = new TextureAtlas(Gdx.files.internal("dungeon.atlas"));

        for (Texture texture : atlas.getTextures()) {
            texture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        }

        errorTexture = atlas.findRegion("error");
        registerBitmask(stoneWalls, "wall_stone_top", TOP);
        registerBitmask(stoneWalls, "wall_stone_left", LEFT);

        registerVariants(stoneFloors, "stone_floor");
        registerVariants(woodenFloors, "wooden_floor");

        verticalDoorClosed = find("vertical_door_closed");
        verticalDoorOpen = find("vertical_door_open");
        horizontalDoorClosed = find("horizontal_door_closed");
        horizontalDoorOpen = find("horizontal_door_open");

    }

    public TextureRegion getStoneWall(int bitmask) {
        if (isOOB(bitmask)) return errorTexture;
        return stoneWalls[bitmask];
    }

    public TextureRegion getStoneFloor(int x, int y) {
        return getDeterministicVariant(stoneFloors, x, y);
    }

    public TextureRegion getWoodFloor(int x, int y) {
        return getDeterministicVariant(woodenFloors, x, y);
    }

    private TextureRegion find(String name) {
        TextureRegion region = atlas.findRegion(name);
        return (region != null) ? region : errorTexture;
    }

    private void registerBitmask(TextureRegion[] array, String name, int... tags) {
        int id = 0;
        for (int t : tags) id |= t;
        TextureRegion region = atlas.findRegion(name);
        if (region != null) {
            array[id] = region;
            return;
        }
        // ! LOG
    }

    private void registerVariants(Array<TextureRegion> array, String name) {
        for (TextureAtlas.AtlasRegion region : atlas.getRegions()) {
            if (region.name.contains(name)) {
                array.add(region);
            }
        }
    }

    private TextureRegion getDeterministicVariant(Array<TextureRegion> list, int x, int y) {
        if (list.size == 0) return errorTexture;
        int idx = (x * 73856093 ^ y * 19349663) % list.size;
        return list.get(Math.abs(idx));
    }

    private boolean isOOB(int idx) { return idx < 0 || idx >= Bitmask.COMBINATIONS; }

    @Override
    public void dispose() {
        if (atlas != null) atlas.dispose();
    }

}
