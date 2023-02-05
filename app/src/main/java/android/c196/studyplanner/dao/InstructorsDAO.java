package android.c196.studyplanner.dao;

import android.c196.studyplanner.entities.Assessments;
import android.c196.studyplanner.entities.Instructors;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface InstructorsDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Instructors instructors);

    @Update
    void update(Instructors instructors);

    @Delete
    void delete(Instructors instructors);

    @Query("SELECT * FROM Instructors WHERE courseId=:courseId")
    public List<Instructors> getInstructorsInCourse(int courseId);

    @Query("UPDATE Instructors " + "SET name = :instructorName, phone=:instructorPhone, email=:instructorEmail " + "WHERE id = :instructorId" )
    void updateById(int instructorId, String instructorName, String instructorPhone, String instructorEmail);

    @Query("DELETE FROM Instructors WHERE id=:id")
    void deleteById(int id);
}
