package my.edu.tarc.lab4_1sharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import my.edu.tarc.lab4_4sharedpreference.R;

public class SettingsActivity extends AppCompatActivity {
    public static final String FILE_NAME = "my.edu.tarc.lab4_4sharedpreference";
    private EditText editTextName;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale, radioButtonFemale;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        editTextName = findViewById(R.id.editTextName);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);

        sharedPreferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
        String name;
        name = sharedPreferences.getString("user_name", "");

        int gender; //-1 = none, 1 = male, 0 = female
        gender = sharedPreferences.getInt("gender", -1);

        editTextName.setText(name);

        if(gender == 1){
            radioButtonMale.setChecked(true);
        }else if(gender == 0){
            radioButtonFemale.setChecked(true);
        }else{
            radioGroupGender.clearCheck();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //TODO: Perform data saving action here
        String name = editTextName.getText().toString();
        editor.putString("user_name",  name);

        int gender;
        gender = radioGroupGender.getCheckedRadioButtonId();

        if(gender == R.id.radioButtonMale){
            editor.putInt("gender", 1);
        }else if(gender == R.id.radioButtonFemale){
            editor.putInt("gender", 0);
        }else{
            editor.putInt("gender", -1);
        }

        editor.commit();
    }
}
