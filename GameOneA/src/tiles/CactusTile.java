package tiles;

import gfx.Assets;

public class CactusTile extends Tile {
    public CactusTile(int id){
        super(Assets.cactusfloor, id);
    }
    public boolean isSolid(){
        return true;
    }
}