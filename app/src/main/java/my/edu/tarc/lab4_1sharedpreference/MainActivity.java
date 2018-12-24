package my.edu.tarc.lab4_1sharedpreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import my.edu.tarc.lab4_4sharedpreference.R;

public class MainActivity extends AppCompatActivity {
    private static final String FILE_NAME = "";
    private ImageView imageViewProfile;
    private TextView textViewName;
    private EditText editTextName;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale, radioButtonFemale;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        imageViewProfile = findViewById(R.id.imageViewProfile);
        textViewName = findViewById(R.id.textViewName);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);


        sharedPreferences = getSharedPreferences(SettingsActivity.FILE_NAME, MODE_PRIVATE);
        String name;
        name = sharedPreferences.getString("user_name", "");

        int gender; //-1 = none, 1 = male, 0 = female
        gender = sharedPreferences.getInt("gender", -1);

        textViewName.setText(name);

        if(gender == 1){
            imageViewProfile.setImageResource(R.drawable.male);
        }else if(gender == 0){
            imageViewProfile.setImageResource(R.drawable.female);
        }else{
            imageViewProfile.setImageResource(R.drawable.profile);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();

        }
}
