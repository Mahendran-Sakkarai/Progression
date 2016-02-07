package com.yaiyaiyaa.progression;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by mahendran on 28/12/15.
 */
public class Progression extends ProgressDialog {
    private int mProgressColor;
    private int mLoader;
    private AnimationDrawable animateLoader;
    private String mLoadingText;
    private int mBackGroundColor;

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
        this.mBackGroundColor = 0x00000000;
        this.mLoadingText = "Loading..";
    }

    public void setColor(int color){
        mProgressColor = color;
    }

    public void setLoadingText(String text){
        mLoadingText = text;
    }

    public void setBackgroundColor(int color){
        mBackGroundColor = color;
    }

    @Override
    public void onCreate(Bundle onSavedInstanceState) {
        super.onCreate(onSavedInstanceState);
        setContentView(R.layout.loader1);

        ImageView loaderContainer = (ImageView) findViewById(R.id.loader_image);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        TextView loadingText = (TextView) findViewById(R.id.loader_text);
        CardView cardViewContainer = (CardView) findViewById(R.id.loading_container);

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
            cardViewContainer.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.VISIBLE);
            progressBar.getIndeterminateDrawable().setColorFilter(mProgressColor, android.graphics.PorterDuff.Mode.MULTIPLY);
            if(mLoadingText != null) {
                loadingText.setText(mLoadingText);
                loadingText.setVisibility(View.VISIBLE);
                loadingText.setTextColor(mProgressColor);
            }
            cardViewContainer.setCardBackgroundColor(mBackGroundColor);
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