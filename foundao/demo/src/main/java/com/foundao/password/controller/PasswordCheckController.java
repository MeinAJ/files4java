package com.foundao.password.controller;

import com.foundao.password.model.FoundaoResult;
import com.foundao.password.model.MParam;
import com.foundao.password.service.PasswordCheckService;
import com.foundao.password.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("static-access")
@RestController
@RequestMapping("/password")
public class PasswordCheckController extends BaseController{

    @Qualifier(value = "passwordCheckServiceImpl")
    @Autowired
    private PasswordCheckService passwordCheckService;

    @RequestMapping(value = "/check",headers = "Accept=*/*",method = RequestMethod.GET,produces = "application/json")
    public String checkPassword(HttpServletRequest request, HttpServletResponse response,
                                @RequestParam String password){
        String resultInfo;
        FoundaoResult foundaoResult = new FoundaoResult();
        try{
            MParam mParam = new MParam();
            mParam.setPassword(password);
            //调用服务
            resultInfo = passwordCheckService.checkPassword(json.toJSONString(mParam));
        }catch(Exception e){
            e.printStackTrace();
            foundaoResult.setCode(Const.FAIL_CODE);
            foundaoResult.setMsg(Const.FAIL_MSG);
            resultInfo = json.toJSONString(foundaoResult);
        }
        return resultInfo;
    }

}
