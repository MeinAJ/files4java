package com.foundao.password.service;

import com.foundao.password.model.FoundaoResult;
import com.foundao.password.model.MParam;
import com.foundao.password.model.WeakPassword;
import com.foundao.password.model.enums.PasswordClassEnum;
import com.foundao.password.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;

@SuppressWarnings("static-access")
@Service(value = "passwordCheckServiceImpl")
public class PasswordCheckServiceImpl extends BaseService implements PasswordCheckService {

    @Qualifier(value = "weakPassword")
    @Autowired
    private WeakPassword weakPassword;

    @Override
    public String checkPassword(String passwordInfo) {
        MParam mParam4Result = new MParam();
        mParam4Result.setPasswordLevel(PasswordClassEnum.C_MID.toString());
        FoundaoResult foundaoResult = new FoundaoResult();
        foundaoResult.setData(mParam4Result);
        try{
            //默认中等强度密码
            MParam mParam4Password = json.parseObject(passwordInfo, MParam.class);
            String password = mParam4Password.getPassword();
            if (password != null && !"".equals(password)){
                password = password.trim();
            }
            List<HashSet<String>> weakPasswordSetList = weakPassword.getWeakPasswordSetList();
            //如果密码为空或者小于6位,认定是弱密码
            if (null == password || password.equals("") || password.length() <= 6){
                //弱密码
                mParam4Result.setPasswordLevel(PasswordClassEnum.C_WEAK.toString());
                return json.toJSONString(foundaoResult);
            }
            //1.弱密码,txt文件中,全是数字,全是字母
            for (HashSet<String> passwordSet : weakPasswordSetList) {
                if (passwordSet.contains(password)){
                    mParam4Result.setPasswordLevel(PasswordClassEnum.C_WEAK.toString());
                    return json.toJSONString(foundaoResult);
                }
            }
            if (password.length() <= 8 && (password.matches(Const.ALL_CHAR_REGEX) || password.matches(Const.ALL_DIGITAL_REGEX))){
                //弱密码
                mParam4Result.setPasswordLevel(PasswordClassEnum.C_WEAK.toString());
                return json.toJSONString(foundaoResult);
            }

            //2.中密码:密码6-9位数,有字母和数字
            if (password.length() <= 10 && password.matches(Const.C_MID_REGEX)){
                mParam4Result.setPasswordLevel(PasswordClassEnum.C_MID.toString());
                return json.toJSONString(foundaoResult);
            }
            //3.强密码:密码位数大于9位数,同时有数字和字母;或者有数字字母和特殊字符
            if ((password.length() >= 12 && password.matches(Const.C_MID_REGEX)) || (password.matches(Const.C_STRONG_REGEX)) && password.length() >= 8){
                mParam4Result.setPasswordLevel(PasswordClassEnum.C_STRONG.toString());
                return json.toJSONString(foundaoResult);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return json.toJSONString(foundaoResult);
    }

}
