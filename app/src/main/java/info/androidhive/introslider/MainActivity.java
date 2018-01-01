package info.androidhive.introslider;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        try {


            Bundle extras = getIntent().getExtras();
            if (extras != null) {


//                String s = extras.getString("EXTRA_SESSION_ID");
                String s[] = getIntent().getStringArrayExtra("EXTRA_SESSION_ID");
                Toast.makeText(this,s.length+" |",Toast.LENGTH_LONG).show();


                //The key argument here must match that used in the other activity
            }

        }catch (Exception ex){
            Toast.makeText(this,"no",Toast.LENGTH_SHORT).show();

        }



        findViewById(R.id.btn_play_again).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // We normally won't show the welcome slider again in real app
                // but this is for testing
                PrefManager prefManager = new PrefManager(getApplicationContext());

                // make first time launch TRUE
                prefManager.setFirstTimeLaunch(true);

                startActivity(new Intent(MainActivity.this, WelcomeActivity.class));
                finish();
            }
        });
    }
}
