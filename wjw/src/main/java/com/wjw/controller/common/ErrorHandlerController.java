package com.wjw.controller.common;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncme.springboot.footstone.constant.BusinessConst;
import com.ncme.springboot.footstone.controller.Controller;
import com.ncme.springboot.footstone.response.RtnBody;

@RestController
public class ErrorHandlerController extends Controller implements ErrorController {

	@Override
	public String getErrorPath() {
		return "/error";
	}

	@RequestMapping("/error")  
    public RtnBody error() {
        return getRtnBody().code(BusinessConst.CODE_RESPONSE_FAIL).message("接口出现异常，请联系管理人员！");  
    }  
}
