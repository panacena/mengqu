package zkk.com.mengqu.base.activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import zkk.com.mengqu.R;


public class BaseActivity extends AppCompatActivity {

	private LinearLayout contentLayout;
	private ViewStub mEmptyLoadingView;
	private ViewStub mEmptyView;
	private FrameLayout childContentLayout;
	private TextView textview_empty_view_title;
	private View view;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		initContentView();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	private void initContentView(){
		  ViewGroup localViewGroup = (ViewGroup)findViewById(android.R.id.content);//2131099744  2131099669  16908290
		  localViewGroup.removeAllViews();
		  contentLayout = new LinearLayout(this);
		  contentLayout.setOrientation(LinearLayout.VERTICAL);
		  localViewGroup.addView(contentLayout);
	    
	  }
	
	
	public void setContentView(int paramInt){
	    childContentLayout = new FrameLayout(this);
	    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
	    this.childContentLayout.setLayoutParams(localLayoutParams);
	    LayoutInflater.from(this).inflate(paramInt, this.childContentLayout, true);
	    LayoutInflater.from(this).inflate(R.layout.activity_base_view, childContentLayout, true);
	    contentLayout.addView(childContentLayout);
	  }
	
	
	public void showEmptyLoading(){
	   
		if (mEmptyLoadingView == null){
			this.mEmptyLoadingView = ((ViewStub)contentLayout.findViewById(R.id.viewstub_empty_loading));
	        this.mEmptyLoadingView.inflate();
	    }
	    mEmptyLoadingView.setVisibility(View.VISIBLE);
	}
	
	public void showEmpty(final IRefreshEmptyViewListener paramIRefreshEmptyViewListener){
		   
		if (mEmptyView == null){
			mEmptyView = ((ViewStub)contentLayout.findViewById(R.id.viewstub_empty_view));
			mEmptyView.inflate();
	    }
		mEmptyView.setVisibility(View.VISIBLE);
		
		 textview_empty_view_title = ((TextView)contentLayout.findViewById(R.id.textview_empty_view_refresh));
		 textview_empty_view_title.setOnClickListener(new View.OnClickListener(){
	        public void onClick(View paramAnonymousView){
	          
	           mEmptyView.setVisibility(View.GONE);
	           showEmptyLoading();
	           paramIRefreshEmptyViewListener.OnRefreshEmptyView();
	        }
	      });
		
		
	}
	
	
	public void hideEmptyLoading(){
	    if (this.mEmptyLoadingView != null)
	      this.mEmptyLoadingView.setVisibility(View.GONE);
	  }

	  public void hideEmptyView() {
	    if (this.mEmptyView != null)
	      this.mEmptyView.setVisibility(View.GONE);
	  }
	
	  
	  public static abstract interface IRefreshEmptyViewListener{
	    public abstract void OnRefreshEmptyView();
	  }
	
}
