package com.developervishalsehgal.twitterclone.Adapters;

import android.opengl.Visibility;

import java.util.ArrayList;

/**
 * Created by developervishal on 01/04/18.
 */

public class NewsFeedModel {

    private String fullName;
    private String userName;
    private String date;
    private String contentText;
    private String replyCount;
    private String retweetCount;
    private String heartCount;
    private int profileImageId;
    private int feedImages;
    private boolean isVisible;

    public int getFeedImages() {
        return feedImages;
    }

    public void setFeedImages(int feedImages) {
        this.feedImages = feedImages;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public NewsFeedModel(String fullName, String userName, String date, String contentText, String replyCount, String retweetCount, String heartCount,int profileImageId,int feedImages, boolean isVisible){
        this.fullName = fullName;
        this.userName = userName;
        this.date = date;
        this.contentText = contentText;
        this.replyCount = replyCount;
        this.retweetCount = retweetCount;
        this.heartCount = heartCount;
        this.profileImageId = profileImageId;
        this.isVisible = isVisible;
        this.feedImages = feedImages;

    }

    public NewsFeedModel() {
    }



    private ArrayList<NewsFeedModel> allItemsInSection;

    public ArrayList<NewsFeedModel> getAllItemsInSection() {
        return allItemsInSection;
    }

    public void setAllItemsInSection(ArrayList<NewsFeedModel> allItemsInSection) {
        this.allItemsInSection = allItemsInSection;
    }

    public int getProfileImageId() {
        return profileImageId;
    }

    public void setProfileImageId(int profileImageId) {
        this.profileImageId = profileImageId;
    }

    private int imageId;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }

    public String getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(String replyCount) {
        this.replyCount = replyCount;
    }

    public String getRetweetCount() {
        return retweetCount;
    }

    public void setRetweetCount(String retweetCount) {
        this.retweetCount = retweetCount;
    }

    public String getHeartCount() {
        return heartCount;
    }

    public void setHeartCount(String heartCount) {
        this.heartCount = heartCount;
    }
}
