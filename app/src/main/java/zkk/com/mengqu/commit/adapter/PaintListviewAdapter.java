package zkk.com.mengqu.commit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import zkk.com.mengqu.R;
import zkk.com.mengqu.commit.bean.ReplyBean;
import zkk.com.mengqu.util.Utils;
import zkk.com.mengqu.view.glide.MyglideImageView;

/**
 * Created by Administrator on 2016/7/4 0004.
 */
public class PaintListviewAdapter extends BaseAdapter {

    List<ReplyBean.DataBean> dataBeanLists=new ArrayList<ReplyBean.DataBean>();
    private Context context;


    public PaintListviewAdapter(Context context, List<ReplyBean.DataBean> dataBeanLists) {
        this.context = context;
        this.dataBeanLists = dataBeanLists;
    }

    @Override
    public int getCount() {
        return dataBeanLists==null?0:dataBeanLists.size();
    }

    @Override
    public Object getItem(int position) {
        return dataBeanLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyReplyHolder myReplyHolder;
        ReplyBean.DataBean dataBeanitem=dataBeanLists.get(position);
        if(convertView==null){
            myReplyHolder=new MyReplyHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.item_comment,null);
            myReplyHolder.comment_img=(ImageView)convertView.findViewById(R.id.comment_img);
            myReplyHolder.comment_username=(TextView) convertView.findViewById(R.id.comment_username);
            myReplyHolder.comment_floor=(TextView) convertView.findViewById(R.id.comment_floor);
            myReplyHolder.comment_content=(TextView) convertView.findViewById(R.id.comment_content);
            myReplyHolder.tv_reply_name=(TextView) convertView.findViewById(R.id.tv_reply_name);
            myReplyHolder.tv_reply_content=(TextView) convertView.findViewById(R.id.tv_reply_content);
            myReplyHolder.comment_time=(TextView) convertView.findViewById(R.id.comment_time);

            myReplyHolder.simg_cover=(ImageView) convertView.findViewById(R.id.simg_cover);
            myReplyHolder.simg_pic=(ImageView) convertView.findViewById(R.id.simg_pic);

            myReplyHolder.ll_relies=(LinearLayout) convertView.findViewById(R.id.ll_relies);
            convertView.setTag(myReplyHolder);
        }else{
            myReplyHolder=(MyReplyHolder) convertView.getTag();
        }

        MyglideImageView.setImg(context,myReplyHolder.comment_img,dataBeanitem.getAvatar());
        myReplyHolder.comment_username.setText(dataBeanitem.getNickname());
        myReplyHolder.comment_floor.setText(dataBeanitem.getFloor()+"#");

        if(dataBeanitem.getContent()!=null&&!"".equals(dataBeanitem.getContent())
                &&dataBeanitem.getImage()!=null&&
                !"".equals(dataBeanitem.getImage())){
            myReplyHolder.comment_content.setVisibility(View.GONE);
            MyglideImageView.setImg(context,myReplyHolder.simg_cover,dataBeanitem.getImage());


            myReplyHolder.simg_cover.setVisibility(View.VISIBLE);
        }else{
            myReplyHolder.simg_cover.setVisibility(View.GONE);
            myReplyHolder.comment_content.setVisibility(View.VISIBLE);
            myReplyHolder.comment_content.setText(dataBeanitem.getContent());
        }

        if(dataBeanitem.getReply()!=null&&!"".equals(dataBeanitem.getReply())
        &&!"null".equals(dataBeanitem.getReply())){
            //有评论
            myReplyHolder.ll_relies.setVisibility(View.VISIBLE);
            try{
                String json = new Gson().toJson(dataBeanitem.getReply());
                JSONObject jsonObject=new JSONObject(json);
                myReplyHolder.tv_reply_name.setText(jsonObject.getString("nickname"));

                if(jsonObject.getString("content")!=null&&!"".equals(jsonObject.getString("content"))
                        &&jsonObject.getString("image")!=null&&
                        !"".equals(jsonObject.getString("image"))){
                    MyglideImageView.setImg(context,myReplyHolder.simg_pic,jsonObject.getString("image"));
                    myReplyHolder.simg_pic.setVisibility(View.VISIBLE);
                    myReplyHolder.tv_reply_content.setVisibility(View.GONE);
                }else{
                    myReplyHolder.tv_reply_content.setText(jsonObject.getString("content"));
                }

            }catch (Exception e){
                 e.printStackTrace();
            }

        }else{
           //无评论
            myReplyHolder.ll_relies.setVisibility(View.GONE);
        }
        myReplyHolder.comment_time.setText(Utils.getRefreshTimeText(dataBeanitem.getCreateTime()+""));
        return convertView;
    }


    class MyReplyHolder{

        ImageView comment_img;
        TextView comment_username,comment_floor,comment_content,tv_reply_name,tv_reply_content,comment_time;
        ImageView simg_cover,simg_pic;
        LinearLayout ll_relies;
    }
}
