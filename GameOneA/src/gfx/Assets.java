package gfx;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 50, height = 50;

    public static BufferedImage player, yeti, fall, desertfloor, rockfloor, cactusfloor, hut, alien;

    public static void init(){
            SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet1.png"));
            DesertFloor desert = new DesertFloor(ImageLoader.loadImage("/textures/desert.jpg"));
            RockFloor rock = new RockFloor(ImageLoader.loadImage("/textures/rockfloor.png"));
            CactusFloor cactus = new CactusFloor(ImageLoader.loadImage("/textures/cactus.png"));


            player = sheet.crop(0,20, width, height);
            alien = sheet.crop(50,0, width, height);
            fall = sheet.crop(150,0, width, height);
            desertfloor = desert.crop(50, 50, width, height);
            rockfloor = rock.crop(50, 50, width, height);
            cactusfloor = cactus.crop(50, 50, width, height);
            hut = sheet.crop(175, 0, width * 2, height * 2);
    }
}
