package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Student {
    private String id;
    private String callnumber;
    private String email;
    private String qq;
    private String wechat;
    private String name;
    private String password;
    private String internship;
    private Byte announcerecruit;
    public Student(){

    }
    public Student(String id,String callnumber,String email,String qq,String wechat,String name,String password,String internship,Byte announcerecruit) {
        this.id = id;
        this.callnumber = callnumber;
        this.email = email;
        this.qq = qq;
        this.wechat = wechat;
        this.name = name;
        this.password = password;
        this.internship = internship;
        this.announcerecruit = announcerecruit;
    }
    @Id
    @Column(name = "id", nullable = false, length = 20)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "callnumber", nullable = true, length = 20)
    public String getCallnumber() {
        return callnumber;
    }

    public void setCallnumber(String callnumber) {
        this.callnumber = callnumber;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "qq", nullable = true, length = 20)
    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @Basic
    @Column(name = "wechat", nullable = true, length = 20)
    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "internship", nullable = true, length = 50)
    public String getInternship() {
        return internship;
    }

    public void setInternship(String internship) {
        this.internship = internship;
    }

    @Basic
    @Column(name = "announcerecruit", nullable = true)
    public Byte getAnnouncerecruit() {
        return announcerecruit;
    }

    public void setAnnouncerecruit(Byte announcerecruit) {
        this.announcerecruit = announcerecruit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) &&
                Objects.equals(callnumber, student.callnumber) &&
                Objects.equals(email, student.email) &&
                Objects.equals(qq, student.qq) &&
                Objects.equals(wechat, student.wechat) &&
                Objects.equals(name, student.name) &&
                Objects.equals(password, student.password) &&
                Objects.equals(internship, student.internship) &&
                Objects.equals(announcerecruit, student.announcerecruit);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, callnumber, email, qq, wechat, name, password, internship, announcerecruit);
    }
}
