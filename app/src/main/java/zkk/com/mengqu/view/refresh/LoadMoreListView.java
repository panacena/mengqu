package zkk.com.mengqu.view.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.LinearLayout;
import android.widget.ListView;

import zkk.com.mengqu.R;

public class LoadMoreListView extends ListView implements OnScrollListener {
    private OnScrollListener mOnScrollListener;
    private OnLastItemVisibleListener mOnLastItemVisibleListener;

    private boolean mLastItemVisible;

    private LinearLayout loadMoreLayout;
    // private LinearLayout noMoreLayout;
    private int totalPosition = 0;


    public void setOnLastItemVisibleListener(OnLastItemVisibleListener onLastItemVisibleListener) {
        this.mOnLastItemVisibleListener = onLastItemVisibleListener;
    }

    public LoadMoreListView(Context context) {
        super(context);
        init(context);
    }

    public LoadMoreListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadMoreListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setOnScrollListener(this);
        View footerView = LayoutInflater.from(context).inflate(R.layout.load_more_footer2, null);
        loadMoreLayout = (LinearLayout) footerView.findViewById(R.id.load_more_footer);
        //  noMoreLayout = (LinearLayout) footerView.findViewById(R.id.no_more_layout);
        addFooterView(footerView);

        loadMoreLayout.setVisibility(View.GONE);
    }


    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (null != mOnLastItemVisibleListener) {
            totalPosition = totalItemCount - 1;
            mLastItemVisible = (totalItemCount > 0)
                    && (firstVisibleItem + visibleItemCount >= totalItemCount - 1);//-1
        }
        if (null != mOnScrollListener) {
            mOnScrollListener.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount);
        }
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

        if (scrollState == OnScrollListener.SCROLL_STATE_IDLE
                && null != mOnLastItemVisibleListener && mLastItemVisible) {
            mOnLastItemVisibleListener.onLastItemVisible();
        }
        if (null != mOnScrollListener) {
            mOnScrollListener.onScrollStateChanged(view, scrollState);
        }
    }

    public enum Mode {
        LOAD,NOMORE,GONE
    }

    public void setFooter(Mode mode) {
        switch (mode) {
            case LOAD:
                loadMoreLayout.setVisibility(View.VISIBLE);
                setSelection(totalPosition);
                break;
            case NOMORE:
                loadMoreLayout.setVisibility(View.GONE);
                //     setSelection(totalPosition);
                break;
            case GONE:
                loadMoreLayout.setVisibility(View.GONE);
                setSelection(totalPosition);
                break;
        }
    }

    public interface OnLastItemVisibleListener {
        void onLastItemVisible();
    }

    public void setmOnScrollListener(OnScrollListener scrollListener) {
        mOnScrollListener = scrollListener;
    }

}