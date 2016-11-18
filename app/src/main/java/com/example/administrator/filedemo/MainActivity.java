package com.example.administrator.filedemo;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    private File fphonedirecotry;
    private File fExternalstoragePublicDiectory;
    private File fExternalstorageDirectory;
    private File fDataStorage;
    private File fDownloadCacheDirectory;
    private File fRootDireCtory;
    private String name,path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.result);
        fphonedirecotry =this.getFilesDir();
        fExternalstorageDirectory= Environment.getExternalStorageDirectory();
        fExternalstoragePublicDiectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
        fDataStorage =Environment.getDataDirectory();
        fRootDireCtory=Environment.getRootDirectory();
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_BAD_REMOVAL)){
            Button btn = (Button) findViewById(R.id.externalStorageDirestory);
            btn.setEnabled(false);
        }
    }
    public void phoneDirectory(View v){
        path=fphonedirecotry.getPath();
        FileOutputStream fos= null;
        try {
            fos = openFileOutput("text.txt",MODE_PRIVATE);
            fos.write("hello".getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        listFile(path);
    }
    public void ExternalstoragePublicDiectory(View v){
        path =fExternalstoragePublicDiectory.getAbsolutePath();
        listFile(path);
    }
    public void ExternalstorageDirectory(View v){
        path =fExternalstorageDirectory.getAbsolutePath();
        listFile(path);
    }
    public void DataStorage(View v){
        path=fDataStorage.getAbsolutePath();
        listFile(path);
    }
    public void DownloadCacheDirectory(View v){
        path=fDownloadCacheDirectory.getAbsolutePath();
        listFile(path);
    }
    public void RootDireCtory(View v){
        path=fRootDireCtory.getAbsolutePath();
        listFile(path);
    }
    public boolean listFile(String path){
        name ="路径:"+path+"\n文件清单\n";
        File file=new File(path);
        if(file.listFiles()!=null&&file.listFiles().length>0){
            for(File f:file.listFiles()){
                path=f.getAbsolutePath();
                name =name+f.getName()+"\n";
            }
        }
        tv1.setText(name);
        return true;
    }
}

