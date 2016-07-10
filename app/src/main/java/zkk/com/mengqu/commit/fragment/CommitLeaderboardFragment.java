/*
 * Created by ttdevs at 16-4-14 下午3:52.
 * E-mail:ttdevs@gmail.com
 * https://github.com/ttdevs
 * Copyright (c) 2016 ttdevs
 */

package zkk.com.mengqu.commit.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import zkk.com.mengqu.R;

public class CommitLeaderboardFragment extends Fragment {

    private List<Fragment> mFragmentList = new ArrayList<>();

    private TabLayout tableLayout;
    private ViewPager viewPager;
    private ApnFragmentAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view=inflater.inflate(R.layout.fragment_commit_leaderboard, container,false);
        mFragmentList.add(LeaderBoardCommitItemFragment.newInstance(1));
        mFragmentList.add(LeaderBoardCommitItemFragment.newInstance(2));
        mFragmentList.add(LeaderBoardCommitItemFragment.newInstance(3));

        tableLayout = (TabLayout)view.findViewById(R.id.commit_tableLayout_leaderboard);
        viewPager = (ViewPager)view.findViewById(R.id.commit_viewPager_leaderboard);

        mAdapter = new ApnFragmentAdapter(getChildFragmentManager());
        viewPager.setAdapter(mAdapter);
        tableLayout.setupWithViewPager(viewPager);
        tableLayout.setTabMode(TabLayout.MODE_FIXED);

        return view;
    }

    private class ApnFragmentAdapter extends FragmentPagerAdapter {
        CharSequence[] TITLE = new CharSequence[]{"日排行","周排行","月排行"};

        public ApnFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return TITLE.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLE[position];
        }
    }
}
