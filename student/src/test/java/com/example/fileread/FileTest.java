package com.example.fileread;

import com.example.student.project.service.CalenderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
@RunWith(SpringRunner.class)
@SpringBootTest()
public class FileTest {
    //@Resource
    //private CalenderService calenderService;

    @Test
    public void testFile(){
        String lu = "/Users/coohua/Downloads/hl";
        getAllFileName(lu,null);
    }


    public static void getAllFileName(String path,CalenderService bean){
        File file = new File(path);
        File [] files = file.listFiles();
        String [] names = file.list();
        if(names != null){
            for(int i=0;i<names.length;i++){
                String name = names[i];
                String[] split = name.split(".");
                String fileName=path+"/"+name;
                getFile(split[0],fileName,bean);
                break;
            }
        }

        //查询子文件夹
        /*for(File a:files){
            if(a.isDirectory()){//如果文件夹下有子文件夹，获取子文件夹下的所有文件全路径。
                getAllFileName(a.getAbsolutePath()+"\\");
            }
        }*/
    }

    public static void getFile(String id,String fileName,CalenderService bean){
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                sbf.append(tempStr);
            }
            reader.close();
            String text = sbf.toString();
            //bean.saveCalender(id,text);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

}
