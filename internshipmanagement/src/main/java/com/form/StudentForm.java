package com.form;

public class StudentForm {
    private String name;
    private String uid;
    private String tel;
    private String email;
    private String qq;
    private String wechat;
    private String emergency_contact;
    private String type="Student";
    private String profile_complete= "true";
    private String intern_state= "1";
    private String messages_count= "2";
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProfile_complete() {
        return profile_complete;
    }

    public void setProfile_complete(String profile_complete) {
        this.profile_complete = profile_complete;
    }

    public String getMessages_count() {
        return messages_count;
    }

    public void setMessages_count(String messages_count) {
        this.messages_count = messages_count;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String id) {
        this.uid = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getEmergency_contact() {
        return emergency_contact;
    }

    public void setEmergency_contact(String emergency_contact) {
        this.emergency_contact = emergency_contact;
    }

    public String getIntern_state() {
        return intern_state;
    }

    public void setIntern_state(String intern_state) {
        this.intern_state = intern_state;
    }
}
