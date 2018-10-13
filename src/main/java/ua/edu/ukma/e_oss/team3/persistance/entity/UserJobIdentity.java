package ua.edu.ukma.e_oss.team3.persistance.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;

public class UserJobIdentity implements Serializable {

    @NotNull
    private int userID;

    @NotNull
    private int companyID;

    @NotNull
    private Date startDate;

    public UserJobIdentity{

    }
    public UserJobIdentity(int userID, int companyID, Date startDate){
        this.userID = userID;
        this.companyID = companyID;
        this.startDate = startDate;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
