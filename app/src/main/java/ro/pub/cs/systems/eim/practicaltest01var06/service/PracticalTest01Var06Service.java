package ro.pub.cs.systems.eim.practicaltest01var06.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.util.Random;

public class PracticalTest01Var06Service extends Service {

    final private IBinder boundedServiceBinder = new BoundedServiceBinder();

    // TODO: exercise 10a - implement a IBinder public class to provide a reference
    // to the service instance through a getService() public method
    public class BoundedServiceBinder extends Binder {
        public PracticalTest01Var06Service getService() {
            return PracticalTest01Var06Service.this;
        }
    }

    // TODO: exercise 10f - override the lifecycle callback method and log a message
    // of the moment they are invoked
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        if (intent.getIntExtra("score", -1) != -1) {
            Log.d("woiejgfoiwrgh", "SCORE = " + intent.getIntExtra("score", -1));
            Intent i = new Intent();
            i.putExtra("score", intent.getIntExtra("score", -1));
            i.putExtra("message", "Victory");
            getApplicationContext().sendBroadcast(i);
        }
        return boundedServiceBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
