package com.dyhm.qiyu;

import android.content.Context;
import android.graphics.Bitmap;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.qiyukf.unicorn.api.ImageLoaderListener;
import com.qiyukf.unicorn.api.UnicornImageLoader;

import java.util.concurrent.ExecutionException;

/**
 * Created by zhoujianghua on 2016/12/27.
 */

public class GlideImageLoader implements UnicornImageLoader {
    private Context context;

    public GlideImageLoader(Context context) {
        this.context = context.getApplicationContext();
    }

    @Override
    public Bitmap loadImageSync(String uri, int width, int height) {
        Bitmap bitmap = null;
        try {
            bitmap = Glide.with(context)
                    .load(uri)
                    .asBitmap().into(width,height).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    @Override
    public void loadImage(String uri, int width, int height, final ImageLoaderListener listener) {
        if (width <= 0) {
            width = Integer.MIN_VALUE;
        }

        if (height <= 0) {
            height = Integer.MIN_VALUE;
        }

        Glide.with(context)
                .load(uri)
                .asBitmap()
                .load(uri).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                if (listener != null) {
                    listener.onLoadComplete(resource);
                }
            }
        });

//        Glide.with(context).
//                asBitmap()
//                .load(uri)
//                .into(new CustomTarget<Bitmap>(width, height) {
//
//            @Override
//            public void onLoadStarted(@Nullable Drawable placeholder) {
//
//            }
//
//            @Override
//            public void onLoadFailed(@Nullable Drawable errorDrawable) {
//
//            }
//
//            @Override
//            public void onResourceReady(@NonNull Bitmap resource, Transition<? super Bitmap> transition) {
//
//            }
//
//            @Override
//            public void onLoadCleared(@Nullable Drawable placeholder) {
//
//            }
//        });
    }
}
