package com.example.squidarcade;

import static ca.yorku.redlightgreenlight.GameView.screenRatioX;
import static ca.yorku.redlightgreenlight.GameView.screenRatioY;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.annotation.CheckResult;

public class Walk {
    public boolean isGoingForward = false;
    int x, y, width, height, walkcounter = 0;
    Bitmap walk1, walk2;

    Walk(int screenX, Resources res){
        walk1 = BitmapFactory.decodeResource(res, R.drawable.character1);
        walk2 = BitmapFactory.decodeResource(res, R.drawable.character2);

        width = walk1.getWidth();
        height = walk1.getHeight();

        width /= 4;
        height /= 4;

        width *= (int) screenRatioY;
        height *= (int) screenRatioX;

        walk1 = Bitmap.createScaledBitmap(walk1, width, height, false);
        walk2 = Bitmap.createScaledBitmap(walk2, width, height, false);

        x = screenX / 2;
        y = (int) (64 * screenRatioX);
    }

    Bitmap getWalk() {
        if (walkcounter == 0) {
            walkcounter++;
            return walk1;
        }
        walkcounter--;
        return walk2;
    }
}
