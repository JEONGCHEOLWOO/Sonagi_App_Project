package com.sona.gi.model.notice.dto;

public class NoticeDto {

    private String id;
    private String textNum;
    private String title;
    private String context;

    private String noticeDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTextNum() {
        return textNum;
    }

    public void setTextNum(String textNum) {
        this.textNum = textNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(String noticeDate) {
        this.noticeDate = noticeDate;
    }
}
