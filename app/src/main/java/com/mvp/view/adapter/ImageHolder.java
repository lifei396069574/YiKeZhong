package com.mvp.view.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * 作者：李飞 on 2017/7/28 11:42
 * 类的用途：
 */

public class ImageHolder implements Holder<String> {
    private SimpleDraweeView imageView;

    @Override
    public View createView(Context context) {
        imageView = new SimpleDraweeView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return imageView;
    }
    @Override
    public void UpdateUI(Context context, int position, String data) {
        Uri uri=Uri.parse(data);
        imageView.setImageURI(uri);
    }

}
