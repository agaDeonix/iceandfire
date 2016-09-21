package ru.androidschool.iceandfire.content;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by deonix on 21/09/16.
 */

public class Character extends RealmObject {

    @PrimaryKey
    @SerializedName("url")
    private String mUrl;
    @SerializedName("name")
    private String mName;
    @SerializedName("gender")
    private String mGender;
    @SerializedName("culture")
    private String mCulture;
    @SerializedName("born")
    private String mBorn;
    @SerializedName("died")
    private List<String> mDied;
    @SerializedName("titles")
    private List<String> mTitles;
    @SerializedName("aliases")
    private List<String> mAliases;
    @SerializedName("father")
    private String mFather;
    @SerializedName("mother")
    private String mMother;
    @SerializedName("spouse")
    private String mSpouse;
    @SerializedName("allegiances")
    private List<String> mAllegiances;
    @SerializedName("books")
    private List<String> mBooks;
    @SerializedName("povBooks")
    private List<String> mPovBooks;
    @SerializedName("tvSeries")
    private List<String> mTvSeries;
    @SerializedName("playedBy")
    private List<String> mPlayedBy;

    public Character(@NonNull String mUrl, @NonNull String mName, String mGender, String mCulture, String mBorn, List<String> mDied, List<String> mTitles, List<String> mAliases, String mFather, String mMother, String mSpouse, List<String> mAllegiances, List<String> mBooks, List<String> mPovBooks, List<String> mTvSeries, List<String> mPlayedBy) {
        this.mUrl = mUrl;
        this.mName = mName;
        this.mGender = mGender;
        this.mCulture = mCulture;
        this.mBorn = mBorn;
        this.mDied = mDied;
        this.mTitles = mTitles;
        this.mAliases = mAliases;
        this.mFather = mFather;
        this.mMother = mMother;
        this.mSpouse = mSpouse;
        this.mAllegiances = mAllegiances;
        this.mBooks = mBooks;
        this.mPovBooks = mPovBooks;
        this.mTvSeries = mTvSeries;
        this.mPlayedBy = mPlayedBy;
    }

    @NonNull
    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    @NonNull
    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getGender() {
        return mGender;
    }

    public void setGender(String mGender) {
        this.mGender = mGender;
    }

    public String getCulture() {
        return mCulture;
    }

    public void setCulture(String mCulture) {
        this.mCulture = mCulture;
    }

    public String getBorn() {
        return mBorn;
    }

    public void setBorn(String mBorn) {
        this.mBorn = mBorn;
    }

    public List<String> getDied() {
        return mDied;
    }

    public void setDied(List<String> mDied) {
        this.mDied = mDied;
    }

    public List<String> getTitles() {
        return mTitles;
    }

    public void setTitles(List<String> mTitles) {
        this.mTitles = mTitles;
    }

    public List<String> getAliases() {
        return mAliases;
    }

    public void setAliases(List<String> mAliases) {
        this.mAliases = mAliases;
    }

    public String getFather() {
        return mFather;
    }

    public void setFather(String mFather) {
        this.mFather = mFather;
    }

    public String getMother() {
        return mMother;
    }

    public void setMother(String mMother) {
        this.mMother = mMother;
    }

    public String getSpouse() {
        return mSpouse;
    }

    public void setSpouse(String mSpouse) {
        this.mSpouse = mSpouse;
    }

    public List<String> getAllegiances() {
        return mAllegiances;
    }

    public void setAllegiances(List<String> mAllegiances) {
        this.mAllegiances = mAllegiances;
    }

    public List<String> getBooks() {
        return mBooks;
    }

    public void setBooks(List<String> mBooks) {
        this.mBooks = mBooks;
    }

    public List<String> getPovBooks() {
        return mPovBooks;
    }

    public void setPovBooks(List<String> mPovBooks) {
        this.mPovBooks = mPovBooks;
    }

    public List<String> getTvSeries() {
        return mTvSeries;
    }

    public void setTvSeries(List<String> mTvSeries) {
        this.mTvSeries = mTvSeries;
    }

    public List<String> getPlayedBy() {
        return mPlayedBy;
    }

    public void setPlayedBy(List<String> mPlayedBy) {
        this.mPlayedBy = mPlayedBy;
    }
}
