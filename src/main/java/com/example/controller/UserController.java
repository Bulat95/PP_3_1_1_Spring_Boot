package com.example.controller;

import com.example.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.model.User;


@Controller
public class UserController {
    private final UserServiceImp service;

    @Autowired
    public UserController(UserServiceImp service) {
        this.service = service;
    }

    @GetMapping("/")
    public String getUserList(Model model) {
        model.addAttribute("listUsers", service.getAllUsers());
        return "index";
    }

    @GetMapping("/new")
    public String getNewUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "new";
    }

    @PostMapping("/saveUserAttr")
    public String saveUser(@ModelAttribute("user") User user) {
        // save user to database
        service.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String editFormForUpdate(@PathVariable("id") Long id, Model model) {
        // get user from the service
        User user = service.getUserById(id);
        // set user as a model attribute to pre-populate the form
        model.addAttribute("user", user);
        return "update";
    }

    @GetMapping("/deleteUserAttr/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        // call delete method user
        service.deleteUserById(id);
        return "redirect:/";
    }
}
