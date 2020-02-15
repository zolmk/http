package com.zolmk.net.http;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import com.zolmk.net.http.helper.BasicListener;
import com.zolmk.net.http.helper.Helper;
import com.zolmk.net.http.utils.FileUtil;
import com.zolmk.net.http.utils.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Http.init();
        init();
    }
    private void init(){
        button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);
        button.setOnClickListener(v -> {
            Helper.downloadImg("1.jpg", FileUtil.PHONE_DCIM, new BasicListener<File,String>() {
                @Override
                public void success(File s) {
                    Toast.show("已保存："+s.getAbsolutePath());
                }

                @Override
                public void error(String s) {
                    Toast.show(s);
                }
            });

        });
    }

}
