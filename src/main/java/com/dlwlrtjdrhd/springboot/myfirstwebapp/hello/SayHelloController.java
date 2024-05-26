package com.dlwlrtjdrhd.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    //localhost:8080/say-hello
    @RequestMapping("say-hello")
    @ResponseBody //메시지가 리턴하는 것 그대로 브라우저에 리턴
    public String sayHello(){
        return  "Hello!";
    }

    @RequestMapping("say-hello-html")
    @ResponseBody //메시지가 리턴하는 것 그대로 브라우저에 리턴
    public String sayHelloHtml(){
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title> My first html </title>");
        sb.append("<body>");
        sb.append("html");
        sb.append("</body>");
        sb.append("</html>");
        return  sb.toString();
    }

    //sayHello.jsp
    //src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
    @RequestMapping("say-hello-jsp")
    public String sayHelloJsp() {
        return "sayHello";
    }


}
