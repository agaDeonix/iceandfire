package ru.androidschool.iceandfire.content;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
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
    private String mDied;
    @SerializedName("titles")
    private RealmList<RealmString> mTitles;
    @SerializedName("aliases")
    private RealmList<RealmString> mAliases;
    @SerializedName("father")
    private String mFather;
    @SerializedName("mother")
    private String mMother;
    @SerializedName("spouse")
    private String mSpouse;
    @SerializedName("allegiances")
    private RealmList<RealmString> mAllegiances;
    @SerializedName("books")
    private RealmList<RealmString> mBooks;
    @SerializedName("povBooks")
    private RealmList<RealmString> mPovBooks;
    @SerializedName("tvSeries")
    private RealmList<RealmString> mTvSeries;
    @SerializedName("playedBy")
    private RealmList<RealmString> mPlayedBy;



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

    public String getDied() {
        return mDied;
    }

    public void setDied(String mDied) {
        this.mDied = mDied;
    }

    public RealmList<RealmString> getTitles() {
        return mTitles;
    }

    public void setTitles(RealmList<RealmString> mTitles) {
        this.mTitles = mTitles;
    }

    public RealmList<RealmString> getAliases() {
        return mAliases;
    }

    public void setAliases(RealmList<RealmString> mAliases) {
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

    public RealmList<RealmString> getAllegiances() {
        return mAllegiances;
    }

    public void setAllegiances(RealmList<RealmString> mAllegiances) {
        this.mAllegiances = mAllegiances;
    }

    public RealmList<RealmString> getBooks() {
        return mBooks;
    }

    public void setBooks(RealmList<RealmString> mBooks) {
        this.mBooks = mBooks;
    }

    public RealmList<RealmString> getPovBooks() {
        return mPovBooks;
    }

    public void setPovBooks(RealmList<RealmString> mPovBooks) {
        this.mPovBooks = mPovBooks;
    }

    public RealmList<RealmString> getTvSeries() {
        return mTvSeries;
    }

    public void setTvSeries(RealmList<RealmString> mTvSeries) {
        this.mTvSeries = mTvSeries;
    }

    public RealmList<RealmString> getPlayedBy() {
        return mPlayedBy;
    }

    public void setPlayedBy(RealmList<RealmString> mPlayedBy) {
        this.mPlayedBy = mPlayedBy;
    }

    public static int getIdFromUrl(String url){
        int i=url.lastIndexOf("/");
        return Integer.valueOf(url.substring(i+1));
    }

    public static Character createTest() {
        Character result = new Character();
        result.mUrl = "http=//www.anapioficeandfire.com/api/characters/2";
        result.mName = "Walder";
        result.mGender = "Male";
        result.mCulture= "";
        result.mBorn = "";
        result.mDied = "";
        result.mTitles= new RealmList<>();
        result.mAliases = new RealmList<>(new RealmString("Hodor"));
        result.mFather = "";
        result.mMother= "";
        result.mSpouse= "";
        result.mAllegiances = new RealmList<>(new RealmString("http=//www.anapioficeandfire.com/api/houses/362"));
        result.mBooks = new RealmList<>(
                new RealmString("http=//www.anapioficeandfire.com/api/books/1"),
                new RealmString("http=//www.anapioficeandfire.com/api/books/2"),
                new RealmString("http=//www.anapioficeandfire.com/api/books/3"),
                new RealmString("http=//www.anapioficeandfire.com/api/books/5"),
                new RealmString("http=//www.anapioficeandfire.com/api/books/8")
        );
        result.mPovBooks = new RealmList<>();
        result.mTvSeries = new RealmList<>(
                new RealmString("Season 1"),
                new RealmString("Season 2"),
                new RealmString("Season 3"),
                new RealmString("Season 4"),
                new RealmString("Season 6")
        );
        result.mPlayedBy = new RealmList<>(new RealmString("Kristian Nairn"));
        return result;
    }

    public Character copyTo(Character newCopy) {
//        Character newCopy = new Character();
        newCopy.mTvSeries = mTvSeries;
        newCopy.mUrl = mUrl;
        newCopy.mName = mName;
        newCopy.mGender = mGender;
        newCopy.mCulture = mCulture;
        newCopy.mBooks = mBooks;
        newCopy.mBorn = mBorn;
        newCopy.mDied = mDied;
        newCopy.mTitles = mTitles;
        newCopy.mAliases = mAliases;
        newCopy.mFather = mFather;
        newCopy.mMother = mMother;
        newCopy.mSpouse = mSpouse;
        newCopy.mAllegiances = mAllegiances;
        newCopy.mPovBooks = mPovBooks;
        newCopy.mPlayedBy = mPlayedBy;
        return newCopy;
    }
}
