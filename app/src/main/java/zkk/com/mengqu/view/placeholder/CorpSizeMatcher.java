package zkk.com.mengqu.view.placeholder;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/**
 * 默认图片尺寸匹配器
 * Created by ling(quan.ling@hotmail.com) on 16/5/23.
 */
public interface CorpSizeMatcher {
    /**
     * 获取中心图片大小
     * @param bounds    控件尺寸
     * @return 图片Rect
     */
    Rect getBounds(Drawable origin, Rect bounds);

     abstract class MatcherFactory {
        /**
         *
         * @param origin 原drawble
         * @param bounds imageview大小
         * @return 匹配器
         */
        public abstract CorpSizeMatcher getMatcher(Drawable origin, Rect bounds);
    }
}
