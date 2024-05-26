package com.dlwlrtjdrhd.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

    private AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {// 생성자 만들면 스프링은 생성자 주입?을 이용함 주입하면 authen~~service 검색함=>bean으로 만들어야함
        this.authenticationService = authenticationService;
    }

    private Logger logger = LoggerFactory.getLogger(getClass());

    //Model 관련해서 배운다!
    //GET, POST
    @RequestMapping(value = "login", method = RequestMethod.GET) /////////url
    ///get 요청에 대해서만 이 메소드 사용
    public String gotoLoginPagd() {
        //System.out.println("Request param is " + name); //console에 찍히는 것, //not recommended

        //logger로 로깅레벨 설정할 수 있음
        logger.debug("param is ");
        logger.info("info level");
        logger.warn("warn level");

        return "Login"; // jsp 파일이름
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model){

        if(authenticationService.authenticate(name, password)) {
            model.put("name", name);
            model.put("password", password);

            //Authentication
            //name - mmjj
            //pw - mj

            return "welcome";
        }
        model.put("errorMessage", "Invalid Credentials! Please try again");
        return "Login";



    }
}
