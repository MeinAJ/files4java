package com.aj.service.news.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class LoginController {


	/**
	 * 登录
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getBannerInfo(HttpServletRequest request) {

		String resultInfo = "";

		try {
			System.out.println("kaishi dddddddddd");
		} catch (Exception e) {

		}
		return resultInfo;
	}

}