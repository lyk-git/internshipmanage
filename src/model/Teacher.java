package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Teacher {
    private String id;
    private String name;
    private String email;
    private String wechat;
    private String qq;
    private String callnumber;
    private String password;
    private Byte isengineerteacher;

    @Id
    @Column(name = "id", nullable = false, length = 20)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "wechat", nullable = true, length = 20)
    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
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
    @Column(name = "callnumber", nullable = true, length = 20)
    public String getCallnumber() {
        return callnumber;
    }

    public void setCallnumber(String callnumber) {
        this.callnumber = callnumber;
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
    @Column(name = "isengineerteacher", nullable = true)
    public Byte getIsengineerteacher() {
        return isengineerteacher;
    }

    public void setIsengineerteacher(Byte isengineerteacher) {
        this.isengineerteacher = isengineerteacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(id, teacher.id) &&
                Objects.equals(name, teacher.name) &&
                Objects.equals(email, teacher.email) &&
                Objects.equals(wechat, teacher.wechat) &&
                Objects.equals(qq, teacher.qq) &&
                Objects.equals(callnumber, teacher.callnumber) &&
                Objects.equals(password, teacher.password) &&
                Objects.equals(isengineerteacher, teacher.isengineerteacher);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, email, wechat, qq, callnumber, password, isengineerteacher);
    }
}
