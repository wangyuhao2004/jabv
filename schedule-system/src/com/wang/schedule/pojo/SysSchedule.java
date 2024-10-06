package com.wang.schedule.pojo;


import java.util.Objects;

public class SysSchedule {
    private Integer sid;
    private Integer uid;
    private String title;
    private Integer completed;


    public SysSchedule() {
    }

    public SysSchedule(Integer sid, Integer uid, String title, Integer completed) {
        this.sid = sid;
        this.uid = uid;
        this.title = title;
        this.completed = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysSchedule that = (SysSchedule) o;
        return Objects.equals(sid, that.sid) && Objects.equals(uid, that.uid) && Objects.equals(title, that.title) && Objects.equals(completed, that.completed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, uid, title, completed);
    }

    /**
     * 获取
     * @return sid
     */
    public Integer getSid() {
        return sid;
    }

    /**
     * 设置
     * @param sid
     */
    public void setSid(Integer sid) {
        this.sid = sid;
    }

    /**
     * 获取
     * @return uid
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * 设置
     * @param uid
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * 获取
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取
     * @return completed
     */
    public Integer getCompleted() {
        return completed;
    }

    /**
     * 设置
     * @param completed
     */
    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

    public String toString() {
        return "SysSchedule{sid = " + sid + ", uid = " + uid + ", title = " + title + ", completed = " + completed + "}";
    }
}
