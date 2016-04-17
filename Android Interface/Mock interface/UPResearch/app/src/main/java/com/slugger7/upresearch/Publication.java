package com.slugger7.upresearch;

/**
 * Created by Nathan on 4/15/2016.
 */
public class Publication {

    private String name;
    private String url;
    private String dueDate;
    private boolean complete;
    private int progress;
    private boolean active;
    private long id;

    public Publication(String name, String url, String dueDate, boolean complete, int progress, boolean active, long id) {
        this.name = name;
        this.url = url;
        this.dueDate = dueDate;
        this.complete = complete;
        this.progress = progress;
        this.active = active;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public boolean getComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name;
    }
}
