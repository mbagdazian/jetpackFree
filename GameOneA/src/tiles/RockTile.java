package tiles;

import gfx.Assets;

public class RockTile extends Tile {
    public RockTile(int id){
        super(Assets.rockfloor, id);
    }
    public boolean isSolid(){
        return true;
    }

}