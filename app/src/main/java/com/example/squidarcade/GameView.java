package com.example.squidarcade;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Runnable {
    private Thread thread;
    private boolean isPlaying;
    private background back1, back2;
    private int screenX, screenY;
    private Paint paint;
    public static float screenRatioX, screenRatioY;

    public GameView(Context context, int screenX, int screenY) {
        super(context);
        this.screenX = screenX;
        this.screenY = screenY;

        screenRatioX = 1080f / screenX;
        screenRatioY = 1080f / screenY;
        back1 = new background(screenX, screenY, getResources());
        back2 = new background(screenX, screenY, getResources());


        back2.x = screenX;
        back2.y = screenY;
        paint = new Paint();
    }

    @Override
    public void run() {
        while (isPlaying) {
            update();
            draw();
            sleep();
        }

    }

    private void update() {
        back1.y -= 30 * screenRatioY;
        back2.y -= 30 * screenRatioY;
        if (back1.y + back1.background.getWidth() < 0) {
            back1.y = screenY;

        }
        if (back2.y + back2.background.getWidth() < 0) {
            back2.y = screenY;

        }

    }

    private void draw() {
        if (getHolder().getSurface().isValid()) {
            Canvas canvas = getHolder().lockCanvas();
            canvas.drawBitmap(back1.background, back1.x, back1.y, paint);
            canvas.drawBitmap(back2.background, back2.x, back2.y, paint);
            getHolder().unlockCanvasAndPost(canvas);
        }

    }

    private void sleep() {
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resume() {
        isPlaying = true;
        thread = new Thread(this);
        thread.start();
    }

    public void pause() {
        try {
            isPlaying = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
