package dev.claudiocarvalho.schedule.ui.actitivy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import dev.claudiocarvalho.schedule.R;
import dev.claudiocarvalho.schedule.dao.StudentDAO;

public class StudentsListActivity extends AppCompatActivity {

    public static final String APPBAR_TITLE = "Student List";
     private final StudentDAO dao = new StudentDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_list);
        setTitle(APPBAR_TITLE);
        setFabNewStudent();

    }

    private void setFabNewStudent() {
        FloatingActionButton buttonNewStudent = findViewById(R.id.activity_students_list_fab_new_student);
        buttonNewStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFormStudentActivity();
            }
        });
    }

    private void openFormStudentActivity() {
        startActivity(new Intent(this, StudentsFormActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        setList();
    }

    private void setList() {
        ListView studentList = findViewById(R.id.activity_students_list_listview);
        studentList.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dao.allStudents()));
    }
}
