package com.example.android.quakereport;

public class Earthquake {

    private Double mMagnitude;
    private String mCity;
    private String mDate;
    private String mTime;
    private String mLink;

    public Earthquake(Double magnitude, String city, String date, String time, String link){
        mMagnitude = magnitude;
        mCity = city;
        mDate = date;
        mTime = time;
        mLink = link;
    }

    public Double getMagnitude(){
        return mMagnitude;
    };

    public String getCity(){
        return mCity;
    };

    public String getDate(){
        return mDate;
    };

    public String getTime(){
        return mTime;
    };

    public String getLink(){
        return mLink;
    };
}
