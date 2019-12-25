package com.maple.playerlibrary.player;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.Toast;

import com.maple.playerlibrary.R;
import com.shuyu.gsyvideoplayer.video.NormalGSYVideoPlayer;

public class VideoPlayer extends NormalGSYVideoPlayer {


    public VideoPlayer(Context context, Boolean fullFlag) {
        super(context, fullFlag);
    }

    public VideoPlayer(Context context) {
        super(context);
    }

    public VideoPlayer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void init(Context context) {
        super.init(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_video_normal;
    }

    @Override
    public ImageView getFullscreenButton() {
        return findViewById(R.id.fullscreen);
    }
}