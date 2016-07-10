package zkk.com.mengqu.game.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import zkk.com.mengqu.R;
import zkk.com.mengqu.game.adapter.GamePageAdapter;

/**
 * Created by Administrator on 2016/7/1 0001.
 */
public class GameFragment extends Fragment implements android.view.View.OnClickListener{

        private ViewPager pager;
        private View view;
        private GamePageAdapter gamePageAdapter;
        private TextView game_tv_info,game_tv_topic;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            view=inflater.inflate(R.layout.fragment_game, container,false);
            return view;
        }
        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            super.onActivityCreated(savedInstanceState);
            init();
        }


        /**
         * pager�������ߵ���
         * @param paramInt
         */
    private void setActionBarTabSelected(int paramInt){

        if(paramInt==0){
            game_tv_info.setSelected(true);
            game_tv_topic.setSelected(false);

            game_tv_info.setTextColor(getResources().getColor(R.color.white2));
            game_tv_topic.setTextColor(getResources().getColor(R.color.blue));
        }else if(paramInt==1){
            game_tv_topic.setSelected(true);
            game_tv_info.setSelected(false);


            game_tv_topic.setTextColor(getResources().getColor(R.color.white2));
            game_tv_info.setTextColor(getResources().getColor(R.color.blue));
        }
    }



    private void init(){

        game_tv_info=(TextView)view.findViewById(R.id.game_tv_info);
        game_tv_topic=(TextView)view.findViewById(R.id.game_tv_topic);

        pager=(ViewPager)view.findViewById(R.id.game_viewPager);
        pager.setOffscreenPageLimit(2);
        pager.setPageMargin(getResources().getDimensionPixelSize(R.dimen.page_margin_width));
        pager.setPageMarginDrawable(R.color.gray_background);
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                // TODO Auto-generated method stub
                setActionBarTabSelected(arg0);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });


        gamePageAdapter=new GamePageAdapter(getChildFragmentManager());
        pager.setAdapter(gamePageAdapter);
        pager.setCurrentItem(0);
        game_tv_info.setSelected(true);
    }

    @Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub
        switch (arg0.getId()) {
            case R.id.game_tv_info:
                setActionBarTabSelected(0);
                pager.setCurrentItem(0);
                break;
            case R.id.game_tv_topic:
                setActionBarTabSelected(1);
                pager.setCurrentItem(1);
                break;
            default:
                break;
        }
    }
}
