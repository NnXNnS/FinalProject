package com.bcaf.ivan.FinalProject.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {



    @GetMapping
    @RequestMapping("/login")
    public String login(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        String userId=(String)session.getAttribute("connectedUser");
        if(userId==null || userId.isEmpty())
            return "login";
        else
            return "redirect:/";
    }
}
