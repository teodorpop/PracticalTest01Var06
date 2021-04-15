package ro.pub.cs.systems.eim.practicaltest01var06;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class PracticalTest01Var06SecondaryActivity extends AppCompatActivity {
    class KeypadClickListener implements View.OnClickListener {
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.ok:
                    Intent intent = new Intent();
                    intent.putExtra("score", score);
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                    break;

            }
        }
    }

    private KeypadClickListener myClickListener = new KeypadClickListener();
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var06_secondary);

        Intent intent = getIntent();
        if (intent != null) {
            int count = intent.getIntExtra("count", -1);
            int intstar = intent.getIntExtra("intstar", -1);
            int intzero = intent.getIntExtra("intzero", -1);
            int intone = intent.getIntExtra("intone", -1);
            if (intstar == intzero && intzero == intone && intzero != -1) {
                switch (count) {
                    case 0:
                        ((TextView)findViewById(R.id.gained)).setText("Gained: 100");
                        score = 100;
                        break;
                    case 1:
                        ((TextView)findViewById(R.id.gained)).setText("Gained: 50");
                        score = 50;
                        break;
                    case 2:
                        ((TextView)findViewById(R.id.gained)).setText("Gained: 10");
                        score = 10;
                        break;
                    default:
                        ((TextView)findViewById(R.id.gained)).setText("Gained: 0");
                        score = 0;
                        break;
                }

            } else {
                ((TextView)findViewById(R.id.gained)).setText("Gained: 0");
            }
        }

        findViewById(R.id.ok).setOnClickListener(myClickListener);
    }
}
