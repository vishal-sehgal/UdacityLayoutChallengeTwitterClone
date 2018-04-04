package com.developervishalsehgal.twitterclone.Adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.opengl.Visibility;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.developervishalsehgal.twitterclone.R;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

/**
 * Created by developervishal on 01/04/18.
 */

public class NewsFeedAdapter extends RecyclerView.Adapter<NewsFeedAdapter.SingleItemRowHolder> {

    private List<NewsFeedModel> itemsList;
    private Context mContext;


    public NewsFeedAdapter(Context context, List<NewsFeedModel> itemsList) {
        this.itemsList = itemsList;
        this.mContext = context;
    }

    @Override
    public void onBindViewHolder(final SingleItemRowHolder holder, int i) {

        holder.setIsRecyclable(false);
        final NewsFeedModel singleItem = itemsList.get(i);

        holder.full_name.setText(singleItem.getFullName());
        holder.user_name.setText(singleItem.getUserName());
        holder.time.setText(singleItem.getDate());
        holder.content_text.setText(singleItem.getContentText());
        holder.reply_count.setText(singleItem.getReplyCount());
        holder.retweet_count.setText(singleItem.getRetweetCount());
        holder.heart_count.setText(singleItem.getHeartCount());

        Glide.with(mContext).load(singleItem.getProfileImageId()).into(holder.profileImageFeed);


        if(holder.feedImage.getVisibility()==View.VISIBLE){

            Glide.with(mContext).load(singleItem.getFeedImages()).into(holder.feedImage);
        }


        if(singleItem.isVisible()){
            holder.feedImage.setVisibility(View.VISIBLE);

        }else{

        holder.feedImage.setVisibility(View.GONE);

        }

    }



    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.newsfeed_single_item, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }


    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);
    }



    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView full_name,user_name,time,content_text,reply_count,heart_count,retweet_count,messages;
        protected ImageView profileImageFeed, feedImage;
        private final Context context;

        public SingleItemRowHolder(View view) {
            super(view);

            context = view.getContext();
            this.full_name = (TextView) view.findViewById(R.id.full_name);
            this.user_name = (TextView) view.findViewById(R.id.user_name);
            this.time = (TextView) view.findViewById(R.id.time);
            this.content_text = (TextView) view.findViewById(R.id.content_text);
            this.reply_count = (TextView) view.findViewById(R.id.reply_count);
            this.heart_count = (TextView) view.findViewById(R.id.heart_count);
            this.retweet_count = (TextView) view.findViewById(R.id.retweet_count);
            this.profileImageFeed = (ImageView) view.findViewById(R.id.profile_img_feed);
            this.feedImage = view.findViewById(R.id.img_feed);
            this.messages = view.findViewById(R.id.message_post);
        }

        }
}
