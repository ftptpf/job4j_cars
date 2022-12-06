package ru.job4j.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.service.PostService;
import ru.job4j.util.GuestUtil;

import javax.servlet.http.HttpSession;

@Controller
public class PostController {

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping("/index")
    public String index(Model model, HttpSession session) {
        GuestUtil.checkAndSetGuestName(model, session);
        model.addAttribute("posts", service.findAll());
        return "index";
    }

    @GetMapping("/actual")
    public String actual(Model model, HttpSession session) {
        GuestUtil.checkAndSetGuestName(model, session);
        model.addAttribute("posts", service.findAllSale());
        return "index";
    }

    @GetMapping("/sold")
    public String sold(Model model, HttpSession session) {
        GuestUtil.checkAndSetGuestName(model, session);
        model.addAttribute("posts", service.findAllSold());
        return "index";
    }

    @GetMapping("/add")
    public String add(Model model, HttpSession session) {
        GuestUtil.checkAndSetGuestName(model, session);
        return "add";
    }
}
