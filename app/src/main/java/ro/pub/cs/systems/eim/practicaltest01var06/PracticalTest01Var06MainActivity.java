package ro.pub.cs.systems.eim.practicaltest01var06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class PracticalTest01Var06MainActivity extends AppCompatActivity {
    class KeypadClickListener implements View.OnClickListener {
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.play:
                    break;

            }
        }
    }

    private KeypadClickListener myClickListener = new KeypadClickListener();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var06_main);

        findViewById(R.id.play).setOnClickListener(myClickListener);
    }
}