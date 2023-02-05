package android.c196.studyplanner.dao;

import android.c196.studyplanner.entities.Assessments;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AssessmentsDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Assessments assessments);

    @Update
    void update(Assessments assessments);

    @Delete
    void delete(Assessments assessments);

    @Query("SELECT * FROM Assessments")
    public List<Assessments> getAllAssessments();

    @Query("SELECT * FROM Assessments WHERE courseId=:courseId")
    public List<Assessments> getAssessmentsByCourseId(int courseId);

    @Query("DELETE FROM Assessments WHERE id=:id")
    void deleteById(int id);

    @Query("UPDATE Assessments " + "SET title = :assessmentTitle, startDate = :assessmentStart, endDate = :assessmentEnd " + "WHERE id = :assessmentID" )
    void updateAssessmentDetailsById(int assessmentID, String assessmentTitle, String assessmentStart, String assessmentEnd);
}
