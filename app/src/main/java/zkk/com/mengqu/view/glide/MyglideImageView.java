package zkk.com.mengqu.view.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;

import jp.wasabeef.glide.transformations.CropCircleTransformation;
import zkk.com.mengqu.R;
import zkk.com.mengqu.util.Utils;
import zkk.com.mengqu.view.placeholder.CorpDrawableBuilder;

/**
 * Created by Administrator on 2016/6/13 0013.
 */
public class MyglideImageView {


    public static void setImg(Context context, ImageView ivImg,String imgurl){
//
      //  Drawable drawable = context.getResources().getDrawable(R.drawable.ic_launcher);
       /* Resources res= context.getResources();
        Bitmap bmp = BitmapFactory.decodeResource(res, R.drawable.ic_launcher);
        BitmapDrawable bd= new BitmapDrawable(res, bmp);*/
      //  Drawable drawable2=zoomDrawable(drawable,30,30);
        Glide.with(context)
                .load(imgurl)
                .placeholder(CorpDrawableBuilder.build( ActivityCompat.getDrawable(context, R.drawable.ic_launcher), Color.WHITE))
                .centerCrop()
                .into(ivImg);

    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        // 取 drawable 的长宽
        int w = drawable.getIntrinsicWidth();
        int h = drawable.getIntrinsicHeight();

        // 取 drawable 的颜色格式
        Bitmap.Config config = drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                : Bitmap.Config.RGB_565;
        // 建立对应 bitmap
        Bitmap bitmap = Bitmap.createBitmap(w, h, config);
        // 建立对应 bitmap 的画布
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, w, h);
        // 把 drawable 内容画到画布中
        drawable.draw(canvas);
        return bitmap;
    }
    public static Drawable zoomDrawable(Drawable drawable, int w, int h) {
        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        // drawable转换成bitmap
        Bitmap oldbmp = drawableToBitmap(drawable);
        // 创建操作图片用的Matrix对象
        Matrix matrix = new Matrix();
        // 计算缩放比例
        float sx = ((float) w / width);
        float sy = ((float) h / height);
        // 设置缩放比例
        matrix.postScale(sx, sy);
        // 建立新的bitmap，其内容是对原bitmap的缩放后的图
        Bitmap newbmp = Bitmap.createBitmap(oldbmp, 0, 0, width, height,
                matrix, true);
        return new BitmapDrawable(newbmp);
    }
    public static void setRoundImg(Context context, ImageView ivImg,String imgurl){


        Glide.with(context).load(imgurl)
                .bitmapTransform(new CropCircleTransformation(context) )
                .into((ivImg));

    }


    public static void setLocalImg(Context context, ImageView ivImg,Integer localsrc){
        Glide.with(context)
                .load(localsrc)
                .centerCrop()
                .into(ivImg);
    }

    public static void setTextImg(Context context, ImageView ivImg,String imgurl,final ProgressBar textView){
        Glide.with(context)
                .load(imgurl)
                .into(new GlideDrawableImageViewTarget(ivImg) {
                    @Override
                    public void onResourceReady(GlideDrawable drawable, GlideAnimation anim) {
                        super.onResourceReady(drawable, anim);
                        textView.setVisibility(View.GONE);
                    }
                });
    }



    public static void setImgHeight(final Context context,final ImageView ivImg,String imgurl){
        Glide.with(context)//activty
                .load(imgurl)
                .asBitmap()
                .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {

                    @Override
                    public void onResourceReady(Bitmap bitmap, GlideAnimation glideAnimation) {
                        // Do something with bitmap here.
                       // bitmap.getHeight(); //获取bitmap信息，可赋值给外部变量操作，也可在此时行操作。
                       // bitmap.getWidth();

                        float f = Float.valueOf( bitmap.getWidth() /bitmap.getHeight());
                        int i = (int)(Utils.getScreenWidth(context) / f);


                        ViewGroup.LayoutParams layoutParams=ivImg.getLayoutParams();
                        layoutParams.height=Utils.getScreenHeight(context)*i;

                     //   ivImg.setLayoutParams(new PLA_AbsListView.LayoutParams(Utils.getScreenWidth(context), i));
                        ivImg.setLayoutParams(layoutParams);


                        ivImg.setImageBitmap(bitmap);
                    }

                });



    }


    public  static  void  clear(final Context context){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Glide.get(context).clearDiskCache();
            }
        }).start();
        Glide.get(context).clearMemory();
    }
}
