package zkk.com.mengqu.game.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import zkk.com.mengqu.game.fragment.GameInfoFragment;
import zkk.com.mengqu.game.fragment.GoodThemeFragment;

/**
 * Created by Administrator on 2016/7/1 0001.
 */
public class GamePageAdapter extends FragmentStatePagerAdapter {

    GameInfoFragment gameInfoFragment;
    GoodThemeFragment goodThemeFragment;
    public GamePageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                if (gameInfoFragment == null) {
                    gameInfoFragment = GameInfoFragment.newInstance();
                }
                return gameInfoFragment;
            case 1:
                if (goodThemeFragment == null) {
                    goodThemeFragment = GoodThemeFragment.newInstance();
                }
                return goodThemeFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 2;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub
        super.destroyItem(container, position, object);
    }

    @Override
    public Object instantiateItem(ViewGroup arg0, int arg1) {
        // TODO Auto-generated method stub
        return super.instantiateItem(arg0, arg1);
    }

}
