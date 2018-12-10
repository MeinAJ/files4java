package com.example.demo.controller;

import com.example.demo.model.WeakPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;

@SuppressWarnings("static-access")
@RestController
@RequestMapping("/password")
public class PasswordCheckController extends BaseController{

    @Qualifier(value = "weakPassword")
    @Autowired
    private WeakPassword weakPassword;

    @RequestMapping(value = "/check",headers = "Accept=*/*",method = RequestMethod.POST,produces = "application/json")
    public String checkPassword(HttpServletRequest request, HttpServletResponse response, @RequestBody String passwordInfo){
        String resultInfo = "";
        try{

            WeakPassword weakPassword = json.parseObject(passwordInfo, WeakPassword.class);
            System.out.println(passwordInfo);
            HashSet<String> weakPasswordSet = this.weakPassword.getWeakPasswordSet();
            for (String s : weakPasswordSet) {
                if (s.contains(weakPassword.getPassword())){
                    System.out.println("right");
                    break;
                } else {
                    System.out.println("error");
                    break;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("checkPassword....error");
        }
        return resultInfo;
    }

}
