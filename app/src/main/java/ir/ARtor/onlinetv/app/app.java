package ir.ARtor.onlinetv.app;

import android.util.Log;
import android.widget.Toast;

public class app {
    public static final String TAG = "onlineTV";

    public static void log(String msg){
        Log.d(TAG, msg);
    }

    public static void toast(String msg){
        Toast.makeText(application.getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
