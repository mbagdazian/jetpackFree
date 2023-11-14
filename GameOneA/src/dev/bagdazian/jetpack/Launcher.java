package dev.bagdazian.jetpack;

public class Launcher {
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game("Jetpack!", 400, 400);
        game.start();

    }
}
