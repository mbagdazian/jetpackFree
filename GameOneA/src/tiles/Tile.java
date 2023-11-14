package tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
//static stuff
    public static Tile[] tiles = new Tile[256];
    public static Tile desertTile = new DesertTile(0);
    public static Tile rockTile = new RockTile(1);
    public static Tile cactusTile = new CactusTile(2);
    //add more tiles here to assign ID

    //class
    public static final int TILEWIDTH = 50, TILEHEIGHT = 50;

    protected BufferedImage texture;
    protected final int id;

    public Tile(BufferedImage texture, int id){
        this.texture = texture;
        this.id = id;

        tiles[id] = this;
    }
    public void tick(){

    }

    public void render(Graphics g, int x, int y){
        g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null );
    }

    public boolean isSolid(){
        return false;
    }

    public int getID(){
        return id;
    }

}
