package sg.edu.rp.c346.id20011119.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

import sg.edu.rp.c346.id20011119.demomyprofile.R;

public class MainActivity extends AppCompatActivity {

    EditText etName, etGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etGPA = findViewById(R.id.editTextGPA);
        etName = findViewById(R.id.editTextName);

    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefedit = prefs.edit();
        prefedit.putString("Name", etName.getText().toString());
        prefedit.putFloat("GPA", Float.parseFloat(etGPA.getText().toString()));
        prefedit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences pref = getPreferences(MODE_PRIVATE);
        String name = pref.getString("name", "");
        Float gpa = pref.getFloat("GPA", 0f);
        etName.setText(name);
        etGPA.setText(String.valueOf(gpa));


    }
}