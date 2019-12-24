package com.maple.playerlibrary.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BasePlayer extends FrameLayout {
    public BasePlayer(@NonNull Context context) {
        this(context, null, 0);
    }

    public BasePlayer(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BasePlayer(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs, defStyleAttr);
    }

    public Context mContext;

    public void initView(Context context, AttributeSet attrs, int defStyleAttr) {
        this.mContext = context;

    }
}
