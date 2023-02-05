package android.c196.studyplanner.Database;


import android.app.Application;
import android.c196.studyplanner.dao.AssessmentsDAO;
import android.c196.studyplanner.dao.CoursesDAO;
import android.c196.studyplanner.dao.InstructorsDAO;
import android.c196.studyplanner.dao.TermsDAO;
import android.c196.studyplanner.entities.Assessments;
import android.c196.studyplanner.entities.Courses;
import android.c196.studyplanner.entities.Instructors;
import android.c196.studyplanner.entities.Terms;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {
    private TermsDAO mTermsDAO;
    private CoursesDAO mCoursesDAO;
    private AssessmentsDAO mAssessmentDAO;
    private InstructorsDAO mInstructorDAO;
    private List<Terms> mAllTerms;

    private List<Courses> mAllCourses;
    private List<Assessments> mAllAssessments;
    private List<Instructors> mAllInstructors;

    private List<Courses> coursesInTerm;

    private List<Instructors> instructorsInCourse;
    private List<Assessments> assessmentsInCourse;

    private static int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public Repository(Application application){
        DatabaseBuilder db = DatabaseBuilder.getDatabase(application);
        mTermsDAO = db.termsDAO();
        mCoursesDAO = db.courseDAO();
        mAssessmentDAO = db.assessmentsDAO();
        mInstructorDAO = db.instructorsDAO();
    }

    public void insertTerm(Terms term){
        databaseExecutor.execute(()->{
            mTermsDAO.insert(term);
        });
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void deleteTermById(int id){
        databaseExecutor.execute(()->{
            mTermsDAO.deleteById(id);
        });
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Terms> getAllTerms(){
        databaseExecutor.execute(()->{
            mAllTerms = mTermsDAO.getAllTerms();
        });
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mAllTerms;
    }

    public void updateTermDetailsById(int termID, String termTitle, String termStart, String termEnd){
        databaseExecutor.execute(()->{
            mTermsDAO.updateTermDetailsById(termID,termTitle,termStart,termEnd);
        });
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void insertCourse(Courses course){
        databaseExecutor.execute(()->{
            mCoursesDAO.insert(course);
        });
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void deleteCourseById(int courseId){
        databaseExecutor.execute(()->{
            mCoursesDAO.deleteById(courseId);
        });
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Courses> getCoursesInTerm(int termId){
        databaseExecutor.execute(()->{
            coursesInTerm = mCoursesDAO.getCoursesInTerm(termId);
        });
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return coursesInTerm;
    }

    public void insertAssessment(Assessments assessments){
        databaseExecutor.execute(() -> {
            mAssessmentDAO.insert(assessments);
        });
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void deleteAssessmentById(int id) {
        databaseExecutor.execute(() -> {
            mAssessmentDAO.deleteById(id);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void updateAssessmentDetailsById(int assessmentID, String assessmentTitle, String assessmentStart, String assessmentEnd) {
        databaseExecutor.execute(() -> {
            mAssessmentDAO.updateAssessmentDetailsById(assessmentID, assessmentTitle, assessmentStart, assessmentEnd);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Assessments> getAssessmentsInCourse(int courseId){
        databaseExecutor.execute(() -> {
            assessmentsInCourse = mAssessmentDAO.getAssessmentsByCourseId(courseId);
        });
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return assessmentsInCourse;
    }

    public void updateCourseDetailsById(int courseId, String courseTitle, String courseStatus, String courseStart, String courseEnd){
        databaseExecutor.execute(() -> {
            mCoursesDAO.updateById(courseId, courseTitle, courseStatus, courseStart, courseEnd);
        });
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Instructors> getInstructorsInCourse(int courseId){
        databaseExecutor.execute(() -> {
            try {
                instructorsInCourse = mInstructorDAO.getInstructorsInCourse(courseId);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        });
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return instructorsInCourse;
    }

    public void insertInstructor(Instructors instructor){
        databaseExecutor.execute(() -> {
            mInstructorDAO.insert(instructor);
        });
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void updateInstructorById(int instructorId, String instructorName, String instructorPhone, String instructorEmail){
        databaseExecutor.execute(() -> {
            mInstructorDAO.updateById(instructorId, instructorName, instructorPhone, instructorEmail);
        });
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void deleteInstructorById(int instructorId){
        databaseExecutor.execute(() -> {
            mInstructorDAO.deleteById(instructorId);
        });
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
