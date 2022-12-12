package ru.job4j.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.model.Car;
import ru.job4j.model.Post;
import ru.job4j.model.User;
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

    @GetMapping("/newposts")
    public String newPosts(Model model, HttpSession session) {
        GuestUtil.checkAndSetGuestName(model, session);
        model.addAttribute("posts", service.findAllNew());
        return "index";
    }

    @GetMapping("/add")
    public String add(Model model, HttpSession session) {
        GuestUtil.checkAndSetGuestName(model, session);
        return "add";
    }

    @PostMapping("/add")
    public String addPost(Model model, HttpSession session, @ModelAttribute Post post, @ModelAttribute Car car) {
        GuestUtil.checkAndSetGuestName(model, session);
        User user = (User) model.getAttribute("user");
        post.setUser(user);

        return "index";
    }

    @GetMapping("/detail/{postId}")
    public String detail(Model model, @PathVariable("postId") int id, HttpSession session) {
        GuestUtil.checkAndSetGuestName(model, session);
        model.addAttribute("post", service.findById(id));
        return "detail";
    }

    @GetMapping("/sold/{postId}")
    public String sold(Model model, @PathVariable("postId") int id, HttpSession session) {
        service.changeStatusToSold(id);
        return "redirect:/detail/" + id;
    }
}
