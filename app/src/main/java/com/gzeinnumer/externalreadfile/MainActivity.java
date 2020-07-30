package com.gzeinnumer.externalreadfile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.gzeinnumer.externalreadfile.helper.FunctionGlobalDir;
import com.gzeinnumer.externalreadfile.helper.FunctionGlobalFile;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity_";

    TextView tv;
    String msg="externalreadfile\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(TAG);

        tv = findViewById(R.id.tv);

        if (FunctionGlobalDir.isFileExists(FunctionGlobalDir.appFolder+"/File.txt")){
            msg+="File sudah dibuat sebelumnya \n";
            tv.setText(msg);
            List<String> list = FunctionGlobalFile.readFile(FunctionGlobalDir.appFolder+"/File.txt");
            if (list !=null){
                msg+="Jumlah line di file ada "+ list.size();
                tv.setText(msg);
            } else {
                msg+="Gagal membaca data";
                tv.setText(msg);
            }
        } else {
            if(FunctionGlobalFile.initFile("Text yang dibuat di file")){
                List<String> list = FunctionGlobalFile.readFile(FunctionGlobalDir.appFolder+"/File.txt");
                if (list !=null){
                    msg+="Jumlah line di file ada "+ list.size();
                    tv.setText(msg);
                } else {
                    msg+="Gagal membaca data";
                    tv.setText(msg);
                }
            } else {
                msg+="File gagal dibuat ";
                tv.setText(msg);
            }
        }
    }
}