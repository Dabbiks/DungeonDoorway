package io.github.dabbiks;

import com.badlogic.gdx.Game;
import io.github.dabbiks.assets.DungeonAssets;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {

    private DungeonAssets dungeonAssets;

    @Override
    public void create() {
        dungeonAssets = new DungeonAssets();
        dungeonAssets.load();

        setScreen(new FirstScreen());
    }
}
