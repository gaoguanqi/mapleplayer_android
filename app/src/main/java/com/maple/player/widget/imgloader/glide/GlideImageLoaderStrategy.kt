package com.maple.player.widget.imgloader.glide

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.Nullable
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.DrawableImageViewTarget
import com.bumptech.glide.request.transition.Transition
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable
import com.maple.player.GlideApp
import com.maple.player.R
import com.maple.player.widget.imgloader.BaseImageLoaderStrategy
import com.maple.player.widget.imgloader.TransType
import com.maple.player.widget.imgloader.http.ProgressInterceptor
import jp.wasabeef.glide.transformations.BlurTransformation
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class GlideImageLoaderStrategy : BaseImageLoaderStrategy<GlideImageConfig> {

    @SuppressLint("CheckResult")
    override fun loadImage(ctx: Context, config: GlideImageConfig) {
        val options = RequestOptions()
        val shimmerDrawable: ShimmerDrawable = ShimmerDrawable()
        val shimmer: Shimmer =
            Shimmer.AlphaHighlightBuilder().setAutoStart(true).setBaseAlpha(0.9f).setRepeatCount(1)
                .build()
        shimmerDrawable.setShimmer(shimmer)
        options.placeholder(shimmerDrawable)
//        options.placeholder(config.placeholder)
        options.error(config.errorPic)

        if (config.overWidth > 0 && config.overHeight > 0) {
            options.override(config.overWidth, config.overHeight)
        }
        when (config.type) {
            TransType.NORMAL -> loadCommon(ctx, options, config)
            TransType.GIF -> loadGif(ctx, options, config)
            TransType.CIRCLE -> loadCircle(ctx, options, config)
            TransType.ROUND -> loadRound(ctx, options, config)
            TransType.BLUR -> loadBlur(ctx, options, config)
            TransType.CIRCLE_ANR_BLUR -> loadCircleAndBlur(ctx, options, config)
        }
    }


    private fun loadCommon(ctx: Context, options: RequestOptions, config: GlideImageConfig) {
        if (config.progressListener == null) {
            val shimmerDrawable: ShimmerDrawable = ShimmerDrawable()
            val shimmer: Shimmer =
                Shimmer.AlphaHighlightBuilder().setAutoStart(true).setBaseAlpha(0.9f)
                    .setRepeatCount(1).build()
            shimmerDrawable.setShimmer(shimmer)
            config.imageView.setImageDrawable(shimmerDrawable)

            GlideApp.with(ctx)
                .load(config.any)
                .apply(options)
                .into(config.imageView)
        } else {
            loadWhitListener(ctx, options, config)
        }
    }

    private fun loadGif(ctx: Context, options: RequestOptions, config: GlideImageConfig) {
        if (config.progressListener == null) {
            GlideApp.with(ctx)
                .asGif()
                .load(config.any)
                .apply(options)
                .into(config.imageView)
        } else {
            loadWhitListener(ctx, options, config)
        }

    }


    @SuppressLint("CheckResult")
    private fun loadCircle(ctx: Context, options: RequestOptions, config: GlideImageConfig) {
        options.transform(CircleCrop())
        val shimmerDrawable: ShimmerDrawable = ShimmerDrawable()
        val shimmer: Shimmer =
            Shimmer.AlphaHighlightBuilder().setAutoStart(true).setBaseAlpha(0.9f).setRepeatCount(1)
                .build()
        shimmerDrawable.setShimmer(shimmer)
        config.imageView.setImageDrawable(shimmerDrawable)

        if (config.progressListener == null) {
            GlideApp.with(ctx)
                .load(config.any)
                .apply(options)
                .into(config.imageView)
        } else {
            loadWhitListener(ctx, options, config)
        }
    }


    @SuppressLint("CheckResult")
    private fun loadRound(ctx: Context, options: RequestOptions, config: GlideImageConfig) {
        if (config.valueRound <= 0) {
            config.valueRound = 10
        }
        options.transform(RoundedCornersTransformation(config.valueRound, config.valueRound))

        val shimmerDrawable: ShimmerDrawable = ShimmerDrawable()
        val shimmer: Shimmer =
            Shimmer.AlphaHighlightBuilder().setAutoStart(true).setBaseAlpha(0.9f).setRepeatCount(1)
                .build()
        shimmerDrawable.setShimmer(shimmer)
        config.imageView.setImageDrawable(shimmerDrawable)

        if (config.progressListener == null) {
            GlideApp.with(ctx)
                .load(config.any)
                .apply(options)
                .into(config.imageView)
        } else {
            loadWhitListener(ctx, options, config)
        }
    }


    @SuppressLint("CheckResult")
    private fun loadBlur(ctx: Context, options: RequestOptions, config: GlideImageConfig) {
        if (config.valueBlur <= 0) {
            config.valueBlur = 6
        }
        options.transform(BlurTransformation(config.valueBlur))

        val shimmerDrawable: ShimmerDrawable = ShimmerDrawable()
        val shimmer: Shimmer =
            Shimmer.AlphaHighlightBuilder().setAutoStart(true).setBaseAlpha(0.9f).setRepeatCount(1)
                .build()
        shimmerDrawable.setShimmer(shimmer)
        config.imageView.setImageDrawable(shimmerDrawable)

        if (config.progressListener == null) {
            GlideApp.with(ctx)
                .load(config.any)
                .apply(options)
                .into(config.imageView)

        } else {
            loadWhitListener(ctx, options, config)
        }
    }

    @SuppressLint("CheckResult")
    private fun loadCircleAndBlur(ctx: Context, options: RequestOptions, config: GlideImageConfig) {
        if (config.valueBlur <= 0) {
            config.valueBlur = 6
        }
        options.transform(MultiTransformation(CircleCrop(), BlurTransformation(config.valueBlur)))
        val shimmerDrawable: ShimmerDrawable = ShimmerDrawable()
        val shimmer: Shimmer =
            Shimmer.AlphaHighlightBuilder().setAutoStart(true).setBaseAlpha(0.9f).setRepeatCount(1)
                .build()
        shimmerDrawable.setShimmer(shimmer)
        config.imageView.setImageDrawable(shimmerDrawable)

        if (config.progressListener == null) {
            GlideApp.with(ctx)
                .load(config.any)
                .apply(options)
                .into(config.imageView)
        } else {
            loadWhitListener(ctx, options, config)
        }
    }

    private fun loadWhitListener(ctx: Context, options: RequestOptions, config: GlideImageConfig) {
        ProgressInterceptor.addListener(config.any.toString(), config.progressListener!!)
        GlideApp.with(ctx)
            .load(config.any)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(true)
            .apply(options)
            .into(object : DrawableImageViewTarget(config.imageView) {
                override fun onLoadStarted(placeholder: Drawable?) {
                    super.onLoadStarted(placeholder)
                    config.imageView.setImageResource(R.color.color_progress)
                }

                override fun onLoadFailed(@Nullable errorDrawable: Drawable?) {
                    super.onLoadFailed(errorDrawable)
                    ProgressInterceptor.LISTENER_MAP.get(config.any.toString())?.onLoadFailed()
                    config.imageView.setImageResource(config.errorPic)
                }

                override fun onResourceReady(
                    resource: Drawable,
                    transition: Transition<in Drawable>?
                ) {
                    super.onResourceReady(resource, transition)
                    ProgressInterceptor.removeListener(config.any.toString())
                }
            })
    }
}