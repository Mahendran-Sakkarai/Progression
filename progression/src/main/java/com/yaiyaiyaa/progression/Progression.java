package com.yaiyaiyaa.progression;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

/**
 * Created by mahendran on 28/12/15.
 */
public class Progression extends ProgressDialog {
    private int mProgressColor;
    private int mLoader;
    private AnimationDrawable animateLoader;

    public static Progression initProgression(Context context, int loader) {
        Progression progression = new Progression(context, R.style.ProgressionTheme, loader);
        progression.setIndeterminate(true);
        progression.setCancelable(false);
        progression.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
        return progression;
    }

    public Progression(Context context) {
        super(context);
        this.mProgressColor = 0xFFFF0000;
    }

    public Progression(Context context, int theme, int loader) {
        super(context, theme);
        this.mLoader = loader;
        this.mProgressColor = 0xFFFF0000;
    }

    public void setColor(int color){
        if(mLoader == 4)
            mProgressColor = color;
    }

    @Override
    public void onCreate(Bundle onSavedInstanceState) {
        super.onCreate(onSavedInstanceState);
        setContentView(R.layout.loader1);

        ImageView loaderContainer = (ImageView) findViewById(R.id.loader_image);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress_bar);

        if (mLoader == 1) {
            loaderContainer.setBackgroundResource(R.drawable.loader1);
            animateLoader = (AnimationDrawable) loaderContainer.getBackground();
        } else if (mLoader == 2) {
            loaderContainer.setBackgroundResource(R.drawable.loader2);
            animateLoader = (AnimationDrawable) loaderContainer.getBackground();
        } else if (mLoader == 3) {
            loaderContainer.setBackgroundResource(R.drawable.loader3);
            animateLoader = (AnimationDrawable) loaderContainer.getBackground();
        } else if (mLoader == 4){
            loaderContainer.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
            progressBar.getIndeterminateDrawable().setColorFilter(mProgressColor, android.graphics.PorterDuff.Mode.MULTIPLY);
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