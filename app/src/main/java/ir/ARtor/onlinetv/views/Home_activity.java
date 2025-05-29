package ir.ARtor.onlinetv.views;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import ir.ARtor.onlinetv.R;
import ir.ARtor.onlinetv.app.app;
import ir.ARtor.onlinetv.fragments.Fav_fragment;
import ir.ARtor.onlinetv.fragments.Rad_fragment;
import ir.ARtor.onlinetv.fragments.Sat_fragment;
import ir.ARtor.onlinetv.fragments.Tv_fragment;

public class Home_activity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView_menu;
    TextView textView_menu;
    ChipNavigationBar chipNavigationBar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//      EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        findViews();
        onclick();
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

    private void findViews() {
        imageView_menu = findViewById(R.id.imageView_menu);
        textView_menu = findViewById(R.id.textView_menu);
        chipNavigationBar = findViewById(R.id.chipNavigationBar);
        drawerLayout = findViewById(R.id.main);
        navigationView = findViewById(R.id.navigationView);
    }

    private void init(){
        navigationView.bringToFront();
        imageView_menu.bringToFront();
        textView_menu.bringToFront();
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (drawerLayout.isOpen()){
                    drawerLayout.close();
                }else {
                    setEnabled(false);
                    getOnBackPressedDispatcher().onBackPressed();
                }
            }
        });
    }


    private void onclick() {
        imageView_menu.setOnClickListener(this);
        textView_menu.setOnClickListener(this);
        chipNavigationBar.setOnItemSelectedListener(i -> {
            if (i == R.id.item_tv) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout, new Tv_fragment()).commit();
                textView_menu.setText(R.string.item_Television);
            }
            else if (i == R.id.item_Satellite){
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout, new Sat_fragment()).commit();
                textView_menu.setText(R.string.item_Satellite);
            }
            else if (i == R.id.item_Radio){
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout, new Rad_fragment()).commit();
                textView_menu.setText(R.string.item_Radio);
            }
            else if (i == R.id.item_Favorite){
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout, new Fav_fragment()).commit();
                textView_menu.setText(R.string.item_Favorite);
            }
        });
        chipNavigationBar.setItemSelected(R.id.item_tv, true);
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.telegram){
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/ProgPack")));
            } else if (id == R.id.rate) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://myket.ir/app/net.telewebion")));
            } else if (id == R.id.aboutUs) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://myket.ir/app/net.telewebion")));
            }else if (id == R.id.share){
                Intent intent = new Intent(Intent.ACTION_SEND).putExtra(Intent.EXTRA_TEXT, "برای دانلود برنامه تلویزیون آنلاین روی لینک زیر کلیک کن:\n" +
                        "\n https://myket.ir/app/net.telewebion").setType("text/plain");
                startActivity(Intent.createChooser(intent, "Share App"));
            } else if (id == R.id.exit) {
                finishAndRemoveTask();
            }
            return false;
        });
    }

    @Override
    public void onClick(View view) {
        if (view == imageView_menu || view == textView_menu) {
            drawerLayout.open();
        }
    }
}