//package com.example.springbootstrap312.controller;
//
//
//import com.example.springbootstrap312.model.Role;
//import com.example.springbootstrap312.model.User;
//import com.example.springbootstrap312.service.RoleService;
//import com.example.springbootstrap312.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/main")
//public class AdminController {
//
//    private final UserService userService;
//    private final RoleService roleService;
//
//    @Autowired
//    public AdminController(UserService userService, RoleService roleService) {
//        this.userService = userService;
//        this.roleService = roleService;
//    }
//
//    @GetMapping("")
//    public String mainPage(Model model) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User user = (User) auth.getPrincipal();
//        model.addAttribute("user", user);
//        model.addAttribute("users", userService.getAllUsers());
//        model.addAttribute("roles", roleService.getAllRoles());
//        return "admin/adminPage";
//    }
//
////    @GetMapping()
////    public String getUsers(Model model) {
////        model.addAttribute("users", userService.getAllUsers());
////        return "admin/users";
////    }
//
//    @GetMapping("/{id}")
//    public String getUserInfoByName(@PathVariable("id") long id, Model model) {
//        User user = userService.getUser(id);
//        model.addAttribute("user", user);
//        model.addAttribute("roles", user.getRoles());
//        return "user/showUser";
//    }
//
//    @GetMapping("/new")
//    public String newUser(@ModelAttribute("user") User user, Model model) {
//        model.addAttribute("roles", roleService.getAllRoles());
//        return "admin/new";
//    }
//
//    @PostMapping()
//    public String addUser(@ModelAttribute("user") User user, @RequestParam("roles") String[] rolesNames) {
//        user.setRoles(roleService.getSetOfRoles(rolesNames));
//        userService.addUser(user);
//        return "redirect:/admin";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String edit(Model model, @PathVariable("id") long id) {
//        User user = userService.getUser(id);
//        model.addAttribute("user", user);
//        model.addAttribute("roles", roleService.getAllRoles());
//        return "admin/edit";
//    }
//
//    @PatchMapping("/{id}")
//    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") long id) {
////                             @RequestParam("roles") String[] rolesNames) {
////        user.setRoles(roleService.getSetOfRoles(rolesNames));
//        userService.updateUser(id, user);
//        return "redirect:/admin";
//    }
//
//    @DeleteMapping("/{id}")
//    public String removeUser(@PathVariable("id") long id) {
//        userService.removeUser(id);
//        return "redirect:/admin";
//    }
//}
