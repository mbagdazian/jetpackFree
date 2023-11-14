package entities.statics;

import dev.bagdazian.jetpack.Handler;
import gfx.Assets;
import tiles.Tile;

import java.awt.*;

public class Hut extends StaticEntity {

    public Hut(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
    }

    public void tick(){

    }

    public void render(Graphics g){
        g.drawImage(Assets.hut,(int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }
}
