package ch.hslu.ad.sw07.balls;

import java.util.Random;

public final class Ball implements Runnable {
    private static final String[] COLORS = {"red", "black", "blue", "yellow", "green", "magenta"};
    private static final Random RANDOM = new Random();
    private static final int MAX_RADIUS = 50;
    private static final int MIN_RADIUS = 20;
    private static final int MAX_SPEED = 20;
    private static final Canvas CANVAS = Canvas.getCanvas();

    private volatile Thread runThread;
    private final Circle circle;
    private final int radius;
    private final int speed;

    public Ball(){
        this.radius = generateRadius();
        this.circle = new Circle(2 * radius, generateStartPosition(), radius, generateRandomColor());
        this.speed = generateSpeed();
    }

    @Override
    public void run() {
        runThread = Thread.currentThread();
        this.circle.makeVisible();

        while (!this.isOnGround() && !runThread.isInterrupted()){
            this.circle.moveVertical(this.speed);
        }

        this.circle.makeInvisible();
    }

    private Boolean isOnGround(){
        return this.circle.getY() + this.radius * 2 >= CANVAS.getHeight();
    }

    private static int generateSpeed(){
        return RANDOM.nextInt(MAX_SPEED) + 1;
    }

    private static int generateRadius(){
        return RANDOM.nextInt(MAX_RADIUS - MIN_RADIUS) + MIN_RADIUS + 1;
    }

    private static int generateStartPosition(){
        return RANDOM.nextInt(CANVAS.getWidth()) + 1;
    }

    private static String generateRandomColor(){
        return COLORS[RANDOM.nextInt(COLORS.length)];
    }
}
