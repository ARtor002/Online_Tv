package ir.ARtor.onlinetv.app;

import android.app.Application;
import android.content.Context;

import java.util.Locale;

public class application extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = this;
        setFont();
    }

    public static Context getContext() {
        return context;
    }

    private void setFont(){
        String font;
        String language = Locale.getDefault().getLanguage();

        if (language.equalsIgnoreCase("English")){
            font = "fonts/pop.ttf";
        }else {
            font = "fonts/ir.ttf";
        }

        fontOverride.setFont(getContext(), font);
    }
}
