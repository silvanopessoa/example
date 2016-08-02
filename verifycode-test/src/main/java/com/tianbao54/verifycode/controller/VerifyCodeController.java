package com.tianbao54.verifycode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.code.kaptcha.Constants;

@Controller
@RequestMapping("/login")
@SessionAttributes(Constants.KAPTCHA_SESSION_KEY)
public class VerifyCodeController {

	@RequestMapping(value = "check", method = RequestMethod.POST)
	@ResponseBody
	public String loginCheck(ModelMap session,@RequestParam(value = "username") String username,@RequestParam(value = "password") String password, @RequestParam(value = "j_code") String kaptchaReceived) {
		
		String kaptchaExpected = String.valueOf(session.get(Constants.KAPTCHA_SESSION_KEY));
		if (kaptchaReceived == null || !kaptchaReceived.equals(kaptchaExpected)) {
			return "kaptcha_error";
		}
		return "success"; 
	}
}
