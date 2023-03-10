package android.c196.studyplanner.entities;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName ="Instructors")
public class Instructors {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int courseId;
    private String name;
    private String phone;
    private String email;

    public Instructors(int id, int courseId, String name, String phone, String email) {
        this.id = id;
        this.courseId = courseId;
        this.name = name;
        this.phone = phone;
        this.email = email;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
