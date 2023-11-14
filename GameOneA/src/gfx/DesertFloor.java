package gfx;

import java.awt.image.BufferedImage;

public class DesertFloor {

    private BufferedImage desert;

    public DesertFloor(BufferedImage desert){
        this.desert = desert;
    }
    public BufferedImage crop(int x, int y, int width, int height){
        return desert.getSubimage(x, y, width, height);
    }
}
