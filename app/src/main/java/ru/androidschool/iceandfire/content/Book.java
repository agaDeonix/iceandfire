package ru.androidschool.iceandfire.content;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by deonix on 21/09/16.
 */

public class Book extends RealmObject {
    @PrimaryKey
    @SerializedName("url")
    private String mUrl;
    @SerializedName("name")
    private String mName;
    @SerializedName("isbn")
    private String mIsbn;
    @SerializedName("authors")
    private RealmList<RealmString> mAuthors;
    @SerializedName("numberOfPages")
    private Integer mNumberOfPages;
    @SerializedName("publisher")
    private String mPublisher;
    @SerializedName("country")
    private String mCountry;
    @SerializedName("mediaType")
    private String mMediaType;
    @SerializedName("released")
    private String mReleased;
    @SerializedName("characters")
    private RealmList<RealmString> mCharacters;
    @SerializedName("povCharacters")
    private RealmList<RealmString> mPovCharacters;

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

    @NonNull
    public String getIsbn() {
        return mIsbn;
    }

    public void setIsbn(String mIsbn) {
        this.mIsbn = mIsbn;
    }

    public RealmList<RealmString> getAuthors() {
        return mAuthors;
    }

    public void setAuthors(RealmList<RealmString> mAuthors) {
        this.mAuthors = mAuthors;
    }

    public Integer getNumberOfPages() {
        return mNumberOfPages;
    }

    public void setNumberOfPages(Integer mNumberOfPages) {
        this.mNumberOfPages = mNumberOfPages;
    }

    public String getPublisher() {
        return mPublisher;
    }

    public void setPublisher(String mPublisher) {
        this.mPublisher = mPublisher;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String mCountry) {
        this.mCountry = mCountry;
    }

    public String getMediaType() {
        return mMediaType;
    }

    public void setMediaType(String mMediaType) {
        this.mMediaType = mMediaType;
    }

    public String getReleased() {
        return mReleased;
    }

    public void setReleased(String mReleased) {
        this.mReleased = mReleased;
    }

    public RealmList<RealmString> getCharacters() {
        return mCharacters;
    }

    public void setCharacters(RealmList<RealmString> mCharacters) {
        this.mCharacters = mCharacters;
    }

    public RealmList<RealmString> getPovCharacters() {
        return mPovCharacters;
    }

    public void setPovCharacters(RealmList<RealmString> mPovCharacters) {
        this.mPovCharacters = mPovCharacters;
    }
}
