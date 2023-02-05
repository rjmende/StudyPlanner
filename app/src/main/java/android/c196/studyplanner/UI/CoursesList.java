package android.c196.studyplanner.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.c196.studyplanner.CourseDetails;
import android.c196.studyplanner.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CoursesList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_list);
        FloatingActionButton fab=findViewById(R.id.CourseFab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CoursesList.this, CourseDetails.class);
                startActivity(intent);
            }
        });
    }
}