package android.c196.studyplanner.dao;


import android.c196.studyplanner.entities.Terms;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TermsDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Terms terms);

    @Update
    void update(Terms terms);

    @Delete
    void delete(Terms terms);

    @Query("SELECT * FROM Terms ORDER BY termID ASC")
    List<Terms> getAllTerms();

    @Query("UPDATE Terms " + "SET termName = :termTitle, startDate = :termStart, endDate = :termEnd " + "WHERE termId = :termID" )
    void updateTermDetailsById(int termID, String termTitle, String termStart, String termEnd);

    @Query("DELETE FROM Terms WHERE termId=:id")
    void deleteById(int id);

    @Query("SELECT * FROM Terms WHERE termId = :termID")
    Terms getTermById(int termID);
}
