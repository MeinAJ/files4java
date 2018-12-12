package com.foundao.password.model;

import com.foundao.password.model.enums.PasswordClassEnum;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WeakPassword {

    private List<HashSet<String>> weakPasswordSetList = new ArrayList<>();

    public WeakPassword(){
        parseWeakPassword();
    }

    private String password;

    //默认是中等强度密码
    private String passwordStatus = PasswordClassEnum.C_MID.toString();

    public String getPasswordStatus() {
        return passwordStatus;
    }

    public void setPasswordStatus(String passwordStatus) {
        this.passwordStatus = passwordStatus;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<HashSet<String>> getWeakPasswordSetList(){
        return weakPasswordSetList;
    }

    //从文件中解析txt文件,一行一行获取,放入HashSet中
    private void parseWeakPassword(){
        try{
            String path = this.getClass().getResource("/").getPath();
            File files = new File(path);
            String[] fileStrList = files.list();
            //如果为空,直接返回
            if (fileStrList == null || fileStrList.length == 0){
                return;
            }
            //获取弱密码文件的文件名
            List<String> fileList = new ArrayList<>();
            for (String fileName : fileStrList) {
                if (fileName.trim().endsWith("password.txt")){
                    fileList.add(fileName);
                }
            }
            List<HashSet<String>> list = new ArrayList<>();
            for (String fileName : fileList) {
                File file = new File(path + "/" + fileName);// Text文件
                BufferedReader br = new BufferedReader(new FileReader(file));// 构造一个BufferedReader类来读取文件
                String password;
                HashSet<String> passwordStrSet = new HashSet<>(100000);
                int count = 0;
                while ((password = br.readLine()) != null) {// 使用readLine方法，一次读一行
                    count++;
                    passwordStrSet.add(password);
                    if (count % 100000 == 0){
                        list.add(passwordStrSet);
                        passwordStrSet = new HashSet<>();
                    }
                }
            }
            weakPasswordSetList = list;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
