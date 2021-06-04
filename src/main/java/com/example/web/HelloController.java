package com.example.web;

import com.mysql.cj.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Controller
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        logger.info("**************index *************");
        return "index";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        logger.info("**************hello *************");
        return "hello";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String login(HttpServletRequest request,@RequestParam String name, ModelMap modelMap) {
    public String login() {
        logger.info("**************login *************");
        /*Enumeration enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()){
            String paraName = (String)enumeration.nextElement();
            String value = request.getParameter(paraName);
            System.out.println("paraName: " + paraName+ ", vlaue: " +value );
        }*/
        /*String name = request.getParameter("name");
        name = StringUtils.isNullOrEmpty(name)?"":name;*/
        //System.out.println("name: " + name);
        return "login";
    }

    @RequestMapping(value = "/verifyLogin", method = RequestMethod.GET)
    public String verifyLogin(HttpServletRequest request, ModelMap modelMap ) {
        logger.info("**************verifyLogin *************");
        String name = request.getParameter("name");
        name = StringUtils.isNullOrEmpty(name)?"":name;
        modelMap.addAttribute("name", name);
        return "verifyLogin";
    }
}
