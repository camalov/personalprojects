package com.company.controller;

import com.company.entity.User;
import com.company.form.UserForm;
import com.company.service.Dummy;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
//@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceInter userService;
/*
    @RequestMapping(method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String nationalityIdStr = request.getParameter("nId");
        Integer nationalityId = null;

        if (nationalityIdStr != null && !nationalityIdStr.trim().isEmpty()) {
            nationalityId = Integer.parseInt(nationalityIdStr);
        }

        List<User> userList = userService.getAll(name, surname, nationalityId);

        request.setAttribute("userList", userList);

        return "users";
    }
    */

    @RequestMapping(method = RequestMethod.GET, value = "/users") //users?name=cemil?surname...
    public ModelAndView index(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "surname", required = false) String surname,
            @RequestParam(value = "nId", required = false) String nationalityIdStr
    ) {
        Integer nationalityId = null;

        if (nationalityIdStr != null && !nationalityIdStr.trim().isEmpty()) {
            nationalityId = Integer.parseInt(nationalityIdStr);
        }

        List<User> userList = userService.getAll(name, surname, nationalityId);

        ModelAndView mv = new ModelAndView("users");
        mv.addObject("userList", userList);

        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/usersm") //users?name=cemil?surname...
    public ModelAndView indexM(@Valid @ModelAttribute("user") UserForm u, BindingResult bindingResult) {
        ModelAndView mv = new ModelAndView("users");

        if (bindingResult.hasErrors()) {
            return mv;
        }

        List<User> userList = userService.getAll(u.getName(), u.getSurname(), u.getNationalityId());

        mv.addObject("userList", userList);

        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login") //users?name=cemil?surname...
    public String login() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();

        if (!authentication.getAuthorities().toString().contains("ROLE_ANONYMOUS")) {
            return "error";
        }

        return "login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/logout") //users?name=cemil?surname...
    public String logout() {
        return "logout";
    }

    @Autowired
    Dummy service;

    @RequestMapping(method = RequestMethod.GET, value = "/foo") //users?name=cemil?surname...
    public String foo() {
        System.out.println("in foo controller");
        service.foo();
        return "users";
    }

    @ModelAttribute("user")
    public UserForm getEmptyUserForm() {
        return new UserForm();
    }
}