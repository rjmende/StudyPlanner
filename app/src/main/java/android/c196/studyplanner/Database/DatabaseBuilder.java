package android.c196.studyplanner.Database;

import android.c196.studyplanner.dao.AssessmentsDAO;
import android.c196.studyplanner.dao.CoursesDAO;
import android.c196.studyplanner.dao.InstructorsDAO;
import android.c196.studyplanner.dao.TermsDAO;
import android.c196.studyplanner.entities.Assessments;
import android.c196.studyplanner.entities.Courses;
import android.c196.studyplanner.entities.Instructors;
import android.c196.studyplanner.entities.Terms;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities={Terms.class, Courses.class, Assessments.class, Instructors.class}, version=1, exportSchema = false)
public abstract class DatabaseBuilder extends RoomDatabase {
    public abstract TermsDAO termsDAO();

    public abstract CoursesDAO courseDAO();

    public abstract AssessmentsDAO assessmentsDAO();

    public abstract InstructorsDAO instructorsDAO();

    private static volatile DatabaseBuilder INSTANCE;

    static DatabaseBuilder getDatabase(final Context context){
        if (INSTANCE == null) {
            synchronized (DatabaseBuilder.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), DatabaseBuilder.class, "PlannerDatabase.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
