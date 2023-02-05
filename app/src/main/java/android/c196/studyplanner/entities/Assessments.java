package android.c196.studyplanner.entities;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName="Assessments")
public class Assessments {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int courseId;
    private String title;
    private String startDate;
    private String endDate;
    private String type;

    public Assessments(int id, int courseId, String title, String startDate, String endDate, String type) {
        this.id = id;
        this.courseId = courseId;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
