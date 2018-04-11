package com.huangasys.tbsdemo2;

import android.Manifest;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity {


    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] perms = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE};
                if (!EasyPermissions.hasPermissions(MainActivity.this, perms)) {
                    EasyPermissions.requestPermissions(MainActivity.this, "需要访问手机存储权限！", 10086, perms);
                } else {
                    startActivity(new Intent(MainActivity.this,TbsActivity.class));
                }
            }
        });
    }
}
