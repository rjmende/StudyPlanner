package android.c196.studyplanner.entities;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="Courses")

public class Courses {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private int termId;
    private String title;
    private String startDate;
    private String endDate;
    private String status;

    public Courses(int id, int termId, String title, String startDate, String endDate, String status) {
        this.id = id;
        this.termId = termId;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTermId() {
        return termId;
    }

    public void setTermId(int termId) {
        this.termId = termId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

