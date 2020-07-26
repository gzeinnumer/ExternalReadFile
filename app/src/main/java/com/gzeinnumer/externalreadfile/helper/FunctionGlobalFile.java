package com.gzeinnumer.externalreadfile.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FunctionGlobalFile {
    private static final String TAG = "FunctionGLobalFile_";

    //create file
    public static void initFile(String text) {
        File file;
        file = new File(FunctionGlobalDir.getStorageCard + FunctionGlobalDir.appFolder +"/File.txt");
        try{
            FileOutputStream f = new FileOutputStream(file);
            PrintWriter writer = new PrintWriter(f);
            writer.println(text+"1");
            writer.println(text+"2");
            writer.println(text+"3");
            writer.flush();
            writer.close();
            f.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static List<String> readFile(String path){
        if (!FunctionGlobalDir.isFileExists(path)){
            FunctionGlobalFile.initFile("Buat file");
        }

        File file = new File(FunctionGlobalDir.getStorageCard+ FunctionGlobalDir.appFolder+ "/File.txt");
        Scanner input;

        List<String> list = new ArrayList<String>();
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            FunctionGlobalDir.myLogD(TAG,e.getMessage());
            return list;
        }

        while (input.hasNextLine()) {
            list.add(input.nextLine());
        }
        return list;
    }
}
