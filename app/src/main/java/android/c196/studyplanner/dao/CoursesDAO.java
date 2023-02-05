package android.c196.studyplanner.dao;

import android.c196.studyplanner.entities.Courses;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CoursesDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Courses courses);

    @Update
    void update(Courses courses);

    @Delete
    void delete(Courses courses);

    @Query("SELECT * FROM Courses ORDER BY id ASC")
    List<Courses> getAllCourses();

    @Query("SELECT * FROM COURSES WHERE termId=:termId")
    public List<Courses> getCoursesInTerm(int termId);

    @Query("DELETE FROM Courses WHERE id=:courseId")
    void deleteById(int courseId);

    @Query("UPDATE Courses " + "SET title=:courseTitle, startDate=:courseStart, endDate=:courseEnd, status=:courseStatus " + "WHERE id=:courseId")
    void updateById(int courseId, String courseTitle, String courseStatus, String courseStart, String courseEnd);

}
