package dev.claudiocarvalho.schedule.ui.actitivy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import dev.claudiocarvalho.schedule.R;
import dev.claudiocarvalho.schedule.dao.StudentDAO;
import dev.claudiocarvalho.schedule.model.Student;

public class StudentsFormActivity extends AppCompatActivity {

    public static final String APPBAR_TITLE = "Student New";
    private EditText inputName;
    private EditText inputPhone;
    private EditText inputEmail;
    private final StudentDAO dao = new StudentDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_form);
        setTitle(APPBAR_TITLE);
        inputInitialization();
        setSaveButton();
    }

    private void setSaveButton() {
        Button saveButton = findViewById(R.id.activity_students_form_button_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student createdStudent = createStudent();
                save(createdStudent);

                startActivity(new Intent(StudentsFormActivity.this, StudentsListActivity.class));


            }
        });
    }

    private void inputInitialization() {
        inputName = findViewById(R.id.activity_students_form_name);
        inputPhone = findViewById(R.id.activity_students_form_phone);
        inputEmail = findViewById(R.id.activity_students_form_email);
    }

    private void save(Student student) {
        dao.save(student);
        finish();
    }

    private Student createStudent() {
        String name = inputName.getText().toString();
        String phone = inputPhone.getText().toString();
        String email = inputEmail.getText().toString();

        return new Student(name, phone, email);
    }
}
