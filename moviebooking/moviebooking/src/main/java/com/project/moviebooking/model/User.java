package com.project.moviebooking.model;


import javax.persistence.*;

@Entity
@Table(name="usertable")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String userid;
    private String pswd;
    private String mailid;
    private Long mobileno;
    private String userName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getMobileno() {
        return mobileno;
    }

    public void setMobileno(Long mobileno) {
        this.mobileno = mobileno;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


   public String getUserid() {
       return userid;
   }

    public void setUserid(String userid) {
    this.userid=userid;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public String getMailid() {
        return mailid;
    }

    public void setMailid(String mailid) {
        this.mailid = mailid;
    }

}
