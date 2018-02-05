package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Applicant {
    private String id;
    private String applyreason;
    private Date startdate;
    private Integer salary=-1;
    private String companynaMe;
    private String companyaddress;
    private String companyconnectpeople;
    private Date enddate;
    private String companyconnectpeoplejob;
    private String jobgetway;
    private String projectteacher;
    private String helpteacher;
    private String studentid;

    @Id
    @Column(name = "id", nullable = false, length = 50)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "applyreason", nullable = true, length = 250)
    public String getApplyreason() {
        return applyreason;
    }

    public void setApplyreason(String applyreason) {
        this.applyreason = applyreason;
    }

    @Basic
    @Column(name = "startdate", nullable = true)
    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    @Basic
    @Column(name = "salary", nullable = true)
    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "companyna me", nullable = true, length = 50)
    public String getCompanynaMe() {
        return companynaMe;
    }

    public void setCompanynaMe(String companynaMe) {
        this.companynaMe = companynaMe;
    }

    @Basic
    @Column(name = "companyaddress", nullable = true, length = 50)
    public String getCompanyaddress() {
        return companyaddress;
    }

    public void setCompanyaddress(String companyaddress) {
        this.companyaddress = companyaddress;
    }

    @Basic
    @Column(name = "companyconnectpeople", nullable = true, length = 50)
    public String getCompanyconnectpeople() {
        return companyconnectpeople;
    }

    public void setCompanyconnectpeople(String companyconnectpeople) {
        this.companyconnectpeople = companyconnectpeople;
    }

    @Basic
    @Column(name = "enddate", nullable = true)
    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    @Basic
    @Column(name = "companyconnectpeoplejob", nullable = true, length = 50)
    public String getCompanyconnectpeoplejob() {
        return companyconnectpeoplejob;
    }

    public void setCompanyconnectpeoplejob(String companyconnectpeoplejob) {
        this.companyconnectpeoplejob = companyconnectpeoplejob;
    }

    @Basic
    @Column(name = "jobgetway", nullable = true, length = 50)
    public String getJobgetway() {
        return jobgetway;
    }

    public void setJobgetway(String jobgetway) {
        this.jobgetway = jobgetway;
    }

    @Basic
    @Column(name = "projectteacher", nullable = true, length = 50)
    public String getProjectteacher() {
        return projectteacher;
    }

    public void setProjectteacher(String projectteacher) {
        this.projectteacher = projectteacher;
    }

    @Basic
    @Column(name = "helpteacher", nullable = true, length = 50)
    public String getHelpteacher() {
        return helpteacher;
    }

    public void setHelpteacher(String helpteacher) {
        this.helpteacher = helpteacher;
    }

    @Basic
    @Column(name = "studentid", nullable = true, length = 20)
    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Applicant applicant = (Applicant) o;
        return Objects.equals(id, applicant.id) &&
                Objects.equals(applyreason, applicant.applyreason) &&
                Objects.equals(startdate, applicant.startdate) &&
                Objects.equals(salary, applicant.salary) &&
                Objects.equals(companynaMe, applicant.companynaMe) &&
                Objects.equals(companyaddress, applicant.companyaddress) &&
                Objects.equals(companyconnectpeople, applicant.companyconnectpeople) &&
                Objects.equals(enddate, applicant.enddate) &&
                Objects.equals(companyconnectpeoplejob, applicant.companyconnectpeoplejob) &&
                Objects.equals(jobgetway, applicant.jobgetway) &&
                Objects.equals(projectteacher, applicant.projectteacher) &&
                Objects.equals(helpteacher, applicant.helpteacher) &&
                Objects.equals(studentid, applicant.studentid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, applyreason, startdate, salary, companynaMe, companyaddress, companyconnectpeople, enddate, companyconnectpeoplejob, jobgetway, projectteacher, helpteacher, studentid);
    }
}
