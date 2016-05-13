package android.bignerdranch.com.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Francisco R. on 07/03/2016.
 */
public class Crime {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Crime(){
        //Generate unique identifier
        this.mId = UUID.randomUUID();
        this.mDate = new Date();
    }
}
