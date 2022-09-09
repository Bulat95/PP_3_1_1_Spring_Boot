package com.example.controller;

import com.example.model.User;
import com.example.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserServiceImp service;

    @Autowired
    public UserController(UserServiceImp service) {
        this.service = service;
    }

    @GetMapping("/")
    public String getListUsers(Model model) {
        // display list of users
        model.addAttribute("listUsers", service.getAllUsers());
        return "index";
    }

    @GetMapping("/showNewUserForm")
    public String getNewUserForm(Model model) {
        // create model attribute to bind form data
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

    @PostMapping("/updateUserAttr")
    public String updateUser(@ModelAttribute("user") User user) {
        // update user to database
        service.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
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