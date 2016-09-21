package ru.androidschool.iceandfire.content;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

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
    private List<String> mAuthors;
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
    private List<String> mCharacters;
    @SerializedName("povCharacters")
    private List<String> mPovCharacters;

    public Book(@NonNull String mUrl, @NonNull String mName, @NonNull String mIsbn, List<String> mAuthors, Integer mNumberOfPages, String mPublisher, String mCountry, String mMediaType, String mReleased, List<String> mCharacters, List<String> mPovCharacters) {
        this.mUrl = mUrl;
        this.mName = mName;
        this.mIsbn = mIsbn;
        this.mAuthors = mAuthors;
        this.mNumberOfPages = mNumberOfPages;
        this.mPublisher = mPublisher;
        this.mCountry = mCountry;
        this.mMediaType = mMediaType;
        this.mReleased = mReleased;
        this.mCharacters = mCharacters;
        this.mPovCharacters = mPovCharacters;
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

    @NonNull
    public String getIsbn() {
        return mIsbn;
    }

    public void setIsbn(String mIsbn) {
        this.mIsbn = mIsbn;
    }

    public List<String> getAuthors() {
        return mAuthors;
    }

    public void setAuthors(List<String> mAuthors) {
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

    public List<String> getCharacters() {
        return mCharacters;
    }

    public void setCharacters(List<String> mCharacters) {
        this.mCharacters = mCharacters;
    }

    public List<String> getPovCharacters() {
        return mPovCharacters;
    }

    public void setPovCharacters(List<String> mPovCharacters) {
        this.mPovCharacters = mPovCharacters;
    }
}
