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
    private final Context mContext;
    private int mLoader;
    private AnimationsContainer mFasterAnimationsContainer;

    public static ProgressDialog initProgression(Context context, int loader) {
        Progression progression = new Progression(context, R.style.ProgressionTheme, loader);
        progression.setIndeterminate(true);
        progression.setCancelable(false);
        progression.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
        return progression;
    }

    public Progression(Context context) {
        super(context);
        this.mContext = context;
    }

    public Progression(Context context, int theme, int loader) {
        super(context, theme);
        this.mLoader = loader;
        this.mContext = context;
    }

    @Override
    public void onCreate(Bundle onSavedInstanceState) {
        super.onCreate(onSavedInstanceState);
        setContentView(R.layout.loader1);

        ImageView loaderContainer = (ImageView) findViewById(R.id.loader_image);

        if (mLoader == 1) {
            mFasterAnimationsContainer = AnimationsContainer
                    .getInstance(loaderContainer, mContext);
            mFasterAnimationsContainer.addAllFrames(AppUtils.progress1,
                    AppUtils.ANIMATION_INTERVAL);
        } else if (mLoader == 2) {
            mFasterAnimationsContainer = AnimationsContainer
                    .getInstance(loaderContainer, mContext);
            mFasterAnimationsContainer.addAllFrames(AppUtils.progress2,
                    AppUtils.ANIMATION_INTERVAL);
        }
    }

    @Override
    public void show() {
        super.show();
        if (mFasterAnimationsContainer != null)
            mFasterAnimationsContainer.start();
    }

    @Override
    public void dismiss() {
        super.dismiss();
        if (mFasterAnimationsContainer != null)
            mFasterAnimationsContainer.stop();
    }
}