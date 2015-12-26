package app.technokratzs.classroomconnect.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import app.technokratzs.classroomconnect.R;


public class FirstActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(FirstActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }).start();
    }

}
