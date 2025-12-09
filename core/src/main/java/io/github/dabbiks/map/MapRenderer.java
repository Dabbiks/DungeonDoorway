package io.github.dabbiks.map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import io.github.dabbiks.assets.DungeonAssets;
import io.github.dabbiks.assets.Terrain;

public class MapRenderer {

    private final DungeonAssets assets;
    private int[][] mapData;
    private int width, height;

    public MapRenderer(DungeonAssets assets, int[][] mapData) {
        this.assets = assets;
        this.mapData = mapData;
        this.width = mapData.length;
        this.height = mapData[0].length;
    }

    public void render(SpriteBatch batch) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                drawTiles(batch, 0, x, y);
            }
        }
    }

    private void drawTiles(SpriteBatch batch, int layer, int x, int y) {
        int tileId = mapData[x][y];
        TextureRegion tex = null;

        switch (layer) {
            case 0: {
                if (tileId == Terrain.FLOOR_STONE) tex = assets.getStoneFloor(x, y);
                if (tileId == Terrain.FLOOR_WOOD) tex = assets.getWoodFloor(x, y);
                if (tileId == Terrain.WALL_STONE) tex = assets.getWoodFloor(x, y);
            }
            default: {
            }
        }
        if (tex != null) batch.draw(tex, x * 24, y * 24);
    }

    private void drawObjects(SpriteBatch batch, int x, int y) {
    }

}
