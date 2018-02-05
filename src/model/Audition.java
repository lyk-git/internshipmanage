package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Audition {
    private String applicantid;
    private String studentid;
    private String counselloropinion;
    private String tutoropinion;
    private String projectteacheropinion;
    private String engineerteacheropinion;
    private String creditackopinion;

    @Id
    @Column(name = "applicantid", nullable = false, length = 50)
    public String getApplicantid() {
        return applicantid;
    }

    public void setApplicantid(String applicantid) {
        this.applicantid = applicantid;
    }

    @Basic
    @Column(name = "studentid", nullable = true, length = 20)
    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    @Basic
    @Column(name = "counselloropinion", nullable = true, length = 100)
    public String getCounselloropinion() {
        return counselloropinion;
    }

    public void setCounselloropinion(String counselloropinion) {
        this.counselloropinion = counselloropinion;
    }

    @Basic
    @Column(name = "tutoropinion", nullable = true, length = 100)
    public String getTutoropinion() {
        return tutoropinion;
    }

    public void setTutoropinion(String tutoropinion) {
        this.tutoropinion = tutoropinion;
    }

    @Basic
    @Column(name = "projectteacheropinion", nullable = true, length = 100)
    public String getProjectteacheropinion() {
        return projectteacheropinion;
    }

    public void setProjectteacheropinion(String projectteacheropinion) {
        this.projectteacheropinion = projectteacheropinion;
    }

    @Basic
    @Column(name = "engineerteacheropinion", nullable = true, length = 100)
    public String getEngineerteacheropinion() {
        return engineerteacheropinion;
    }

    public void setEngineerteacheropinion(String engineerteacheropinion) {
        this.engineerteacheropinion = engineerteacheropinion;
    }

    @Basic
    @Column(name = "creditackopinion", nullable = true, length = 100)
    public String getCreditackopinion() {
        return creditackopinion;
    }

    public void setCreditackopinion(String creditackopinion) {
        this.creditackopinion = creditackopinion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Audition audition = (Audition) o;
        return Objects.equals(applicantid, audition.applicantid) &&
                Objects.equals(studentid, audition.studentid) &&
                Objects.equals(counselloropinion, audition.counselloropinion) &&
                Objects.equals(tutoropinion, audition.tutoropinion) &&
                Objects.equals(projectteacheropinion, audition.projectteacheropinion) &&
                Objects.equals(engineerteacheropinion, audition.engineerteacheropinion) &&
                Objects.equals(creditackopinion, audition.creditackopinion);
    }

    @Override
    public int hashCode() {

        return Objects.hash(applicantid, studentid, counselloropinion, tutoropinion, projectteacheropinion, engineerteacheropinion, creditackopinion);
    }
}
