package uk.aston.ballout.data;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Session {
    @PrimaryKey
    private int sid;

    @ColumnInfo(name = "park_name")
    private String parkName;

    @ColumnInfo(name = "date")
    private String date;

    @ColumnInfo(name = "time_taken")
    private String timeTaken;

    public Session(int id, String pN, String D, String tT) {
        sid = id;
        parkName = pN;
        date = D;
        timeTaken = tT;
    }

    @Ignore
    public Session(String pN, String D, String tT) {
        parkName = pN;
        date = D;
        timeTaken = tT;
    }

    public int getId() {
        return sid;
    }

    public String getName() {
        return parkName;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return timeTaken;
    }




}
