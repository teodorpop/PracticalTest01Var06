package ro.pub.cs.systems.eim.practicaltest01var06;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

public class TestBroadcastReceiver extends BroadcastReceiver {

    private TextView messageTextView;

    public TestBroadcastReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
//        int score = intent.getIntExtra("score", -1);
//        Toast.makeText(getApplication(), "score = " + score, Toast.LENGTH_LONG).show();
    }
}
