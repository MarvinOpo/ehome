package com.uc.ehome.models;

import android.net.Uri;

/**
 * Created by Stephanie Lyn on 9/22/2015.
 */
public class TaskDetails {
    String title, location, status, date, time;
    Uri image;

    public TaskDetails(String title, String location, String status, String date, String time, Uri image) {
        this.title = title;
        this.location = location;
        this.status = status;
        this.date = date;
        this.time = time;
        this.image = image;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Uri getImage() {
        return image;
    }

    public void setImage(Uri image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
