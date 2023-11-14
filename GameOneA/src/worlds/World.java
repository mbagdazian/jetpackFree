package worlds;

import dev.bagdazian.jetpack.Handler;
import entities.Entitymanager;
import entities.creatures.Player;
import entities.statics.Hut;
import tiles.Tile;
import utils.Utils;

import java.awt.*;

public class World {

    private Handler handler;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;
    //entities
    private Entitymanager entityManager;

    public World(Handler handler, String path){
        this.handler = handler;
        entityManager = new Entitymanager(handler, new Player(handler, 100, 100));
        //generates huts
        entityManager.addEntity(new Hut(handler, 100, 250));
        entityManager.addEntity(new Hut(handler, 300, 450));
        loadWorld(path);

        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);
    }

    public void tick(){
        entityManager.tick();

    }

    public void render(Graphics g){
        //calculates the map edges, starting tile
        int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
        int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset()+ handler.getWidth()) / Tile.TILEWIDTH + 1);
        int yStart =(int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
        int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT +1 );

        for(int y = yStart; y < yEnd; y++){
            for(int x = xStart; x < xEnd; x++){
                getTile(x, y).render(g, (int)(x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()), (int)(y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
            }
        }
        //Entities
        entityManager.render(g);

    }
    public Tile getTile(int x, int y){
        //handle out of bounds
        if( x < 0 || y < 0 || x>= width || y>= height)
            //sets default file type
                return Tile.desertTile;

        Tile t = Tile.tiles[tiles[x][y]];

        if(t == null)
            //sets default tile type
            return Tile.desertTile;
        return t;
    }

    private void loadWorld(String path){
        String file = Utils.loadFileAsString(path);
        //splits the txt file world1 each index corresponds to value in txt file
        String[] tokens = file.split("\\s+");

        width =  Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);

        tiles = new int[width][height];
        for(int y = 0;y < height; y++){
            for(int x =0; x < width; x++){
                //converts token array to two dimensions, skips first 4 elements
                tiles[x][y] = Utils.parseInt(tokens[(x + y * width + 4)]);
            }
        }

    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
}
