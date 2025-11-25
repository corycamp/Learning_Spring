package com.practice.SpringBootWeb1;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @ModelAttribute("course")
    public String course(){
        return "Java";
    }

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @RequestMapping("/addWorker")
    public String add(Worker worker){
        return "result";
    }
}
