package com.yaiyaiyaa.progression;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by mahendran on 28/12/15.
 */
public class Progression extends ProgressDialog {
    private int mLoader;
    private AnimationDrawable animateLoader;

    public static ProgressDialog initProgression(Context context, int loader) {
        Progression progression = new Progression(context, R.style.ProgressionTheme, loader);
        progression.setIndeterminate(true);
        progression.setCancelable(false);
        progression.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
        return progression;
    }

    public Progression(Context context) {
        super(context);
    }

    public Progression(Context context, int theme, int loader) {
        super(context, theme);
        this.mLoader = loader;
    }

    @Override
    public void onCreate(Bundle onSavedInstanceState) {
        super.onCreate(onSavedInstanceState);
        setContentView(R.layout.loader1);

        ImageView loaderContainer = (ImageView) findViewById(R.id.loader_image);

        if (mLoader == 1) {
            loaderContainer.setBackgroundResource(R.drawable.loader1);
            animateLoader = (AnimationDrawable) loaderContainer.getBackground();
        } else if (mLoader == 2) {
            loaderContainer.setBackgroundResource(R.drawable.loader2);
            animateLoader = (AnimationDrawable) loaderContainer.getBackground();
        } else if (mLoader == 3) {
            loaderContainer.setBackgroundResource(R.drawable.loader3);
            animateLoader = (AnimationDrawable) loaderContainer.getBackground();
        }
    }

    @Override
    public void show() {
        super.show();
        if (animateLoader != null)
            animateLoader.start();
    }

    @Override
    public void dismiss() {
        super.dismiss();
        if (animateLoader != null)
            animateLoader.stop();
    }
}