package com.example.deepseekai;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setupButtons();
    }
    
    private void setupButtons() {
        // 奇门遁甲排盘
        Button qimenButton = findViewById(R.id.qimen_button);
        qimenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQimenDunjia();
            }
        });
        
        // 大六壬排盘
        Button daliurenButton = findViewById(R.id.daliuren_button);
        daliurenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDaLiuRen();
            }
        });
        
        // 梅花易数排盘
        Button meihuaButton = findViewById(R.id.meihua_button);
        meihuaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMeiHuaYiShu();
            }
        });
    }
    
    private void startQimenDunjia() {
        Intent intent = new Intent(this, QimenDunjiaActivity.class);
        startActivity(intent);
    }
    
    private void startDaLiuRen() {
        Intent intent = new Intent(this, DaLiuRenActivity.class);
        startActivity(intent);
    }
    
    private void startMeiHuaYiShu() {
        Intent intent = new Intent(this, MeiHuaYiShuActivity.class);
        startActivity(intent);
    }
}