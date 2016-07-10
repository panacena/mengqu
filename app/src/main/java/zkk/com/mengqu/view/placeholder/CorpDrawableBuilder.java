package zkk.com.mengqu.view.placeholder;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;

import java.util.ArrayList;
import java.util.List;

/**
 * 默认图片生成器
 * 指定背景颜色和默认原图之后，根据imageView尺寸大小自动生成该大小的默认图片
 * <p/>
 * Created by ling(quan.ling@hotmail.com) on 16/5/11.
 */
public class CorpDrawableBuilder {
    private static class HolderClass {
        private static CorpDrawableBuilder ourInstance = new CorpDrawableBuilder();
    }

    private static CorpDrawableBuilder getInstance() {
        return HolderClass.ourInstance;
    }

    private List<CorpSizeMatcher.MatcherFactory> matchers = new ArrayList<>();

    private CorpDrawableBuilder() {
        matchers.add(new DefaultMatcherFactory());
    }

    /**
     * @param context 设备上下文
     * @param resId   默认图片ID
     * @param bgColor 背景颜色
     * @return 占位符Drawable
     */
    public static Drawable build(Context context, @DrawableRes int resId, int bgColor) {
        return build(context.getResources().getDrawable(resId), bgColor);
    }

    /**
     * @param origin  默认图Drawable
     * @param bgColor 背景颜色
     * @return 占位符Drawable
     */
    public static Drawable build(Drawable origin, int bgColor) {
        return new CorpDrawableBuilder.CorpDrawable(origin, bgColor, CorpDrawableBuilder.getInstance());
    }

    Rect getMatcherBounds(Drawable origin, Rect bounds) {
        Rect rect = null;
        for (int i = matchers.size() - 1; i >= 0; i--) {
            CorpSizeMatcher matcher = matchers.get(i).getMatcher(origin, bounds);
            if (matcher == null) {
                continue;
            }
            rect = matcher.getBounds(origin, bounds);
            if (rect != null) {
                break;
            }
        }
        return rect;
    }

    static class CorpDrawable extends Drawable {
        CorpDrawableBuilder mDrawableBuilder;
        Drawable mOriginDrawable;
        int mBgColor;

        public CorpDrawable(Drawable originDrawable, int color, CorpDrawableBuilder builder) {
            mOriginDrawable = originDrawable;
            mBgColor = color;
            mDrawableBuilder = builder;
        }

        @Override
        public void draw(Canvas canvas) {
            canvas.drawColor(mBgColor);

            mOriginDrawable.draw(canvas);
        }

        @Override
        public void setAlpha(int alpha) {
            mOriginDrawable.setAlpha(alpha);
        }

        @Override
        public void setColorFilter(ColorFilter colorFilter) {
            mOriginDrawable.setColorFilter(colorFilter);
        }

        @Override
        public int getOpacity() {
            return mOriginDrawable.getOpacity();
        }

        @Override
        protected boolean onLevelChange(int level) {
            if (mOriginDrawable != null && mOriginDrawable.setLevel(level)) {
                updateLayerBounds(getBounds());
                return true;
            }

            return super.onLevelChange(level);
        }

        @Override
        protected void onBoundsChange(Rect bounds) {
            super.onBoundsChange(bounds);

            updateLayerBounds(bounds);
        }

        private void updateLayerBounds(Rect bounds) {
            mOriginDrawable.setBounds(mDrawableBuilder.getMatcherBounds(mOriginDrawable, bounds));
        }
    }

    private static class DefaultMatcherFactory extends CorpSizeMatcher.MatcherFactory {
        private static final float percent = 0.4f;

        @Override
        public CorpSizeMatcher getMatcher(Drawable origin, Rect bounds) {
            return new CorpSizeMatcher() {
                @Override
                public Rect getBounds(Drawable origin, Rect bounds) {
                    float factor = (float) origin.getIntrinsicWidth() / origin.getMinimumHeight();
                    int w, h;
                    if (factor > (float) bounds.width() / bounds.height()) {
                        w = (int) (bounds.right * percent);
                        h = (int) (w / factor);
                    } else {
                        h = (int) (bounds.bottom * percent);
                        w = (int) (h * factor);
                    }
                    Rect rect = new Rect();
                    rect.left = (bounds.width() - w) / 2;
                    rect.right = rect.left + w;
                    rect.top = (bounds.height() - h) / 2;
                    rect.bottom = rect.top + h;
                    return rect;
                }
            };
        }
    }
}
