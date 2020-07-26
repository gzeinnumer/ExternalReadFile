package com.gzeinnumer.externalreadfile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

        FunctionGlobalFile.initFile("Text yang dibuat di file");
        List<String> list = FunctionGlobalFile.readFile(FunctionGlobalDir.appFolder+"/File.txt");
        msg+="Jumlah line di file ada "+ list.size();
        tv.setText(msg);
    }
}