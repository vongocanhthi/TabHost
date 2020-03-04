package com.vnat.tabhost;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TabHost tabHost;
    Button btnRegister, btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTab();
        mapping();
        event();
    }

    private void mapping() {
        btnRegister = findViewById(R.id.btnRegister);
        btnLogin = findViewById(R.id.btnLogin);
    }

    private void event() {
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                Toast.makeText(MainActivity.this, "" + tabId, Toast.LENGTH_SHORT).show();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Đăng nhập", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initTab() {
        tabHost = findViewById(R.id.tabHost);
        tabHost.setup();

        //Tạo đối tượng 1 tab có id là tab1
        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("tab1");
        // Thiết lập nội dung layout
        tabSpec1.setContent(R.id.tab1);
        //Thiết lập tiêu đề cho tab
        tabSpec1.setIndicator("Đăng nhập");
        tabHost.addTab(tabSpec1);

        //--------------------------------------- Tab 2
        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("tab2");
        tabSpec2.setContent(R.id.tab2);
        tabSpec2.setIndicator("", getResources().getDrawable(R.drawable.ic_android));
        tabHost.addTab(tabSpec2);

    }
}
