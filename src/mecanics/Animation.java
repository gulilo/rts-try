package mecanics;

import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;

public class Animation {
    private Image[] images;
    private int index;
    private Image currentImage;
    private Timer timer;
    private boolean running;

    public Animation(Image[] images) {
        this.images = images;
        index = 0;
        currentImage = images[0];
        timer = new Timer();
        running = false;
    }

    public void start() {
        if (!running) {
            running = true;
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    next();
                }
            }, 100, 100);
        }
    }

    public void stop() {
        if (running) {
            running = false;
            timer.cancel();
            index = 0;
            currentImage = images[0];
        }
    }

    public void next() {
        index = index == images.length - 1 ? 0 : index + 1;
        currentImage = images[index];
    }

    public Image getCurrentImage() {
        return currentImage;
    }

    public void setCurrentImage(Image currentImage) {
        this.currentImage = currentImage;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
