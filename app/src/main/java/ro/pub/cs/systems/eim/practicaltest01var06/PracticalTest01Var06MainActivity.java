package ro.pub.cs.systems.eim.practicaltest01var06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class PracticalTest01Var06MainActivity extends AppCompatActivity {
    class KeypadClickListener implements View.OnClickListener {
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.play:
                    Random rand = new Random();
                    int intstar = rand.nextInt(3) + 1;
                    int intzero = rand.nextInt(3) + 1;
                    int intone = rand.nextInt(3) + 1;

                    String text = Integer.toString(intstar) + ", " + Integer.toString(intzero) + ", " + Integer.toString(intone);

                    Toast.makeText(getApplication(), text, Toast.LENGTH_LONG).show();

                    int count = 3;
                    if (!((CheckBox)findViewById(R.id.holdstar)).isChecked()) {
                        ((EditText)findViewById(R.id.startext)).setText(Integer.toString(intstar));
                        count--;
                    } else {
                        intstar = Integer.parseInt(((EditText)findViewById(R.id.startext)).getText().toString());
                    }
                    if (!((CheckBox)findViewById(R.id.hold0)).isChecked()) {
                        ((EditText)findViewById(R.id.text0)).setText(Integer.toString(intzero));
                        count--;
                    } else {
                        intzero = Integer.parseInt(((EditText)findViewById(R.id.text0)).getText().toString());
                    }
                    if (!((CheckBox)findViewById(R.id.hold1)).isChecked()) {
                        ((EditText)findViewById(R.id.text1)).setText(Integer.toString(intone));
                        count--;
                    } else {
                        intone = Integer.parseInt(((EditText)findViewById(R.id.text1)).getText().toString());
                    }

                    Intent intent = new Intent("ro.pub.cs.systems.eim.practicaltest01var06.intent.action.PracticalTest01Var06SecondaryActivity");
                    intent.putExtra("count", count);
                    intent.putExtra("intstar", intstar);
                    intent.putExtra("intzero", intzero);
                    intent.putExtra("intone", intone);
                    startActivityForResult(intent, 1);

                    break;
            }
        }

    }

    private int score = 0;

    private KeypadClickListener myClickListener = new KeypadClickListener();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var06_main);

        findViewById(R.id.play).setOnClickListener(myClickListener);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        switch(requestCode) {
            case 1:
                int tmp = intent.getIntExtra("score", -1);
                if (tmp > 0) score += tmp;

                Toast.makeText(getApplication(), "score = " + score, Toast.LENGTH_LONG).show();

                break;
        }
        super.onActivityResult(requestCode, resultCode, intent);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("score", score);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState.get("score") != null) {
            score = savedInstanceState.getInt("score");
        }

        Toast.makeText(getApplication(), "score = " + score, Toast.LENGTH_LONG).show();
    }
}