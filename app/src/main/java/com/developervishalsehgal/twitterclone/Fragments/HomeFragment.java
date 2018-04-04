package com.developervishalsehgal.twitterclone.Fragments;


import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developervishalsehgal.twitterclone.Adapters.NewsFeedAdapter;
import com.developervishalsehgal.twitterclone.Adapters.NewsFeedModel;
import com.developervishalsehgal.twitterclone.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    ArrayList<String> fullName, userName, time, content_text, reply_count, retweet_count, heart_count;
    int[] profileImages, imagesFeed;
    ArrayList<Boolean> feedImage;
    List<NewsFeedModel> finalList;
    NewsFeedAdapter newsFeedAdapter;
    RecyclerView recyclerView;

    View view;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);

        setUpData();
        recyclerView = view.findViewById(R.id.my_home_recycler_view);
        newsFeedAdapter = new NewsFeedAdapter(getContext(), finalList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.getLayoutManager().setAutoMeasureEnabled(true);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(newsFeedAdapter);

        newsFeedAdapter.notifyDataSetChanged();
        setUpSwipeRefresh();
        return view;
    }


    private void setUpData() {

        fullName = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.full_names)));
        userName = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.usernames)));
        time = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.time)));
        content_text = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.content_text)));
        reply_count = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.reply_count)));
        retweet_count = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.retweet_count)));
        heart_count = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.heart_count)));
        profileImages = new int[]{R.drawable.aditisoni, R.drawable.kaushiksanji, R.drawable.shubhamsoni, R.drawable.saurabh, R.drawable.rahulyadav, R.drawable.wadhatkashmiri, R.drawable.nishanks, R.drawable.rakesh, R.drawable.shivamarora,R.drawable.mahi, R.drawable.vishal};
        imagesFeed = new int[]{R.drawable.aditisoni_feed,R.drawable.kaushik_feed,R.drawable.shubham_feed,R.drawable.nav_header_back,R.drawable.nav_header_back,
                R.drawable.nav_header_back,R.drawable.nav_header_back,R.drawable.nav_header_back,R.drawable.shivam_feed,R.drawable.mahi_feed,R.drawable.nav_header_back};
        feedImage = new ArrayList<>();
        feedImage.add(true);
        feedImage.add(true);
        feedImage.add(true);
        feedImage.add(false);
        feedImage.add(false);
        feedImage.add(false);
        feedImage.add(false);
        feedImage.add(false);
        feedImage.add(true);
        feedImage.add(true);
        feedImage.add(true);



        finalList = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            finalList.add(new NewsFeedModel(fullName.get(i), userName.get(i), time.get(i), content_text.get(i), reply_count.get(i), retweet_count.get(i), heart_count.get(i),profileImages[i],imagesFeed[i],feedImage.get(i)));
        }


    }

    SwipeRefreshLayout swipeRefreshLayout;

    private void setUpSwipeRefresh() {
        swipeRefreshLayout = view.findViewById(R.id.refresh_homescreen);
        swipeRefreshLayout.setColorSchemeResources(R.color.bnv_color, R.color.blue_jeans,
                R.color.ufo_green, R.color.vivid_tangelo);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
//                        HomeFragment homeFragment = new HomeFragment();
//                        FragmentManager manager = getSupportFragmentManager();
//                        manager.beginTransaction().replace(R.id.content_main, homeFragment, homeFragment.getTag()).commit();

                        if(newsFeedAdapter != null){
                            newsFeedAdapter.notifyDataSetChanged();
                            Snackbar.make(view,"Refreshed.",Snackbar.LENGTH_SHORT).show();
                        }
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 3000);


            }
        });
    }



}
