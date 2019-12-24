package com.maple.playerlibrary.player;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.maple.playerlibrary.base.BasePlayer;

public class VideoPlayer extends BasePlayer {

    // private IMediaPlayer mMediaPlayer;
    //private SurfaceView mSurfaceView;

    public VideoPlayer(@NonNull Context context) {
        this(context, null, 0);
    }

    public VideoPlayer(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VideoPlayer(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void initView(Context context, AttributeSet attrs, int defStyleAttr) {
        super.initView(context, attrs, defStyleAttr);
//        this.mSurfaceView = new SurfaceView(mContext);
//        mSurfaceView.getHolder().addCallback(new SurfaceHolder.Callback2() {
//            @Override
//            public void surfaceRedrawNeeded(SurfaceHolder holder) {
//
//            }
//
//            @Override
//            public void surfaceCreated(SurfaceHolder holder) {
//
//            }
//
//            @Override
//            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
//                if (mMediaPlayer != null) {
//                    mMediaPlayer.setDisplay(holder);
//                }
//            }
//
//            @Override
//            public void surfaceDestroyed(SurfaceHolder holder) {
//
//            }
//        });
//
//        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, Gravity.CENTER);
//        addView(mSurfaceView, 0, layoutParams);
    }

//    private IMediaPlayer createPlayer() {
//        IjkMediaPlayer ijkMediaPlayer = new IjkMediaPlayer();
//        ijkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "opensles", 1);
//
//        ijkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "overlay-format", IjkMediaPlayer.SDL_FCC_RV32);
//        ijkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "framedrop", 1);
//        ijkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "start-on-prepared", 0);
//
//        ijkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "http-detect-range-support", 1);
//
//        ijkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_CODEC, "skip_loop_filter", 48);
//        ijkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_CODEC, "min-frames", 100);
//        ijkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "enable-accurate-seek", 1);
//
//        ijkMediaPlayer.setVolume(1.0f, 1.0f);
//        return ijkMediaPlayer;
//    }

    //开始加载视频
//    public void load(String mPath) throws IOException {
//        if (mMediaPlayer != null) {
//            mMediaPlayer.stop();
//            mMediaPlayer.release();
//        }
//        mMediaPlayer = createPlayer();
//        setListener(mMediaPlayer);
//        mMediaPlayer.setDisplay(mSurfaceView.getHolder());
//        mMediaPlayer.setDataSource(mContext, Uri.parse(mPath));
//        mMediaPlayer.prepareAsync();
//    }

//    private void setListener(IMediaPlayer player) {
//        player.setOnPreparedListener(new IMediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(IMediaPlayer iMediaPlayer) {
//                if (mMediaPlayer != null) {
//                    mMediaPlayer.start();
//                }
//            }
//        });
//        player.setOnVideoSizeChangedListener(new IMediaPlayer.OnVideoSizeChangedListener() {
//            @Override
//            public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i1, int i2, int i3) {
//
//            }
//        });
//    }
//
//    public void release() {
//        if (mMediaPlayer != null) {
//            mMediaPlayer.reset();
//            mMediaPlayer.release();
//            mMediaPlayer = null;
//        }
//    }
//
//    public void pause() {
//        if (mMediaPlayer != null) {
//            mMediaPlayer.pause();
//        }
//    }
//
//    public void stop() {
//        if (mMediaPlayer != null) {
//            mMediaPlayer.stop();
//        }
//    }
//
//    public void reset() {
//        if (mMediaPlayer != null) {
//            mMediaPlayer.reset();
//        }
//    }
}
