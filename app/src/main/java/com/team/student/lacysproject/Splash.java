package com.team.student.lacysproject;
import android.app.Activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.team.student.lacysproject.R;

/**
 * Created by Forte on 1/18/2015.
 */
public class Splash extends Activity {

    TextView txt1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        txt1 = (TextView)findViewById(R.id.textView);

        Typeface font = Typeface.createFromAsset(this.getAssets(),"fonts/rockwell.ttf");
        txt1.setTypeface(font);

        AnimatorSet set1 = new AnimatorSet();
        set1.play(ObjectAnimator.ofFloat(txt1, "alpha", 0f, 1).setDuration(5000));
        set1.start();
        set1.setStartDelay(6000);

        ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(txt1, "scaleX", 0.5f);
        ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(txt1, "scaleY", 0.5f);

        scaleDownX.setDuration(2000);
        scaleDownY.setDuration(2000);

        AnimatorSet scaleDown = new AnimatorSet();

        scaleDown.play(scaleDownX).with(scaleDownY);
        scaleDown.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

                ObjectAnimator translateX = ObjectAnimator.ofFloat(txt1, "translationX", 0f,0f);
                ObjectAnimator translateY = ObjectAnimator.ofFloat(txt1, "translationY", 0f,200);

                AnimatorSet set = new AnimatorSet();
                set.setDuration(1000);
                set.playTogether(translateX, translateY);
                set.setStartDelay(1000);
                set.setInterpolator(new BounceInterpolator());
                set.start();

                int secondsDelayed = 1;
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.pin_drop);
                        mp.start();
                    }
                }, secondsDelayed * 1400);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        scaleDown.start();

        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(Splash.this, MainActivity.class));
                finish();
            }
        }, secondsDelayed * 6000);
    }
}
