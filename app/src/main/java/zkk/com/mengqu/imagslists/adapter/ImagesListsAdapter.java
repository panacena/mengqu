package zkk.com.mengqu.imagslists.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import zkk.com.mengqu.R;
import zkk.com.mengqu.imagslists.bean.ImagsListBean;
import zkk.com.mengqu.view.glide.MyglideImageView;

/**
 * Created by Administrator on 2016/6/27 0027.
 */
public class ImagesListsAdapter extends BaseAdapter {

  //  List<ImagsListBean> liveBeens=new ArrayList<ImagsListBean>();
    ImagsListBean imagsListBean =new ImagsListBean();
    private Context context;
    private Itemclick itemclick;

    public ImagesListsAdapter() {
    }

    public ImagesListsAdapter(ImagsListBean liveBeen2, Context context) {
        this.imagsListBean = liveBeen2;
        this.context = context;
    }

    @Override
    public int getCount() {
        return imagsListBean.getImages()==null?0:imagsListBean.getImages().size();
    }

    @Override
    public Object getItem(int position) {
        return imagsListBean.getImages().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        HomeHolder homeHolder;
        if(convertView==null){
            homeHolder=new HomeHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.imagelist_item,null);
            homeHolder.iv_img=(ImageView)convertView.findViewById(R.id.iv_img);


            convertView.setTag(homeHolder);
        }else{
            homeHolder=(HomeHolder)convertView.getTag();
        }

        MyglideImageView.setImg(context,homeHolder.iv_img,imagsListBean.getImages().get(position).toString()
                                                    +"?imageView2/1/w/240/h/240");
        homeHolder.iv_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemclick.setMyOnitemclick(position);
            }
        });

        return convertView;
    }

    class HomeHolder{
        ImageView iv_img;
    }

    public  void setItemclick(Itemclick l){
        itemclick=l;
    }
    public interface  Itemclick{
        void setMyOnitemclick(int poistions);
    }
}