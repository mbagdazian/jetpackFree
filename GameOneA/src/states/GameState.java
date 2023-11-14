package states;

import dev.bagdazian.jetpack.Handler;
import worlds.World;

import java.awt.*;

public class GameState extends State {
//game object load here

    private World world;


    public GameState(Handler handler){
        super(handler);
        world = new World(handler,"res/Worlds/world1.txt");
        handler.setWorld(world);

    }

    public void tick(){
        world.tick();


    }

    public void render(Graphics g){
        world.render(g);

    }

}
