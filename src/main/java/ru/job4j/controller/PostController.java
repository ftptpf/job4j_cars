package ru.job4j.controller;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.job4j.model.Car;
import ru.job4j.model.Post;
import ru.job4j.model.User;
import ru.job4j.service.BodyService;
import ru.job4j.service.PostService;
import ru.job4j.service.UserService;
import ru.job4j.util.GuestUtil;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class PostController {

    private final PostService service;
    private final UserService userService;
    private final BodyService bodiesService;

    public PostController(PostService service,
                          UserService userService,
                          BodyService bodiesService) {
        this.service = service;
        this.userService = userService;
        this.bodiesService = bodiesService;
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

    @GetMapping("/newPosts")
    public String newPosts(Model model, HttpSession session) {
        GuestUtil.checkAndSetGuestName(model, session);
        model.addAttribute("posts", service.findAllNew());
        return "index";
    }

    @GetMapping("/add")
    public String add(Model model, HttpSession session) {
        GuestUtil.checkAndSetGuestName(model, session);
        model.addAttribute("bodies", bodiesService.findAll());
        model.addAttribute("brands", brandsService.findAll());
        model.addAttribute("engines", enginesService.findAll());

        return "add";
    }

    @PostMapping("/add")
    public String addPost(Model model, HttpSession session,
                          @ModelAttribute Post post,
                          @ModelAttribute Car car,
                          @RequestParam ("file") MultipartFile file) throws IOException {
        GuestUtil.checkAndSetGuestName(model, session);
        post.setPhoto(file.getBytes());
        User user = (User) model.getAttribute("user");
        post.setUser(userService.findById(user.getId()));
        post.setCar(car);
        service.saveOrUpdate(post);
        return "redirect:/index";
    }

    @GetMapping("/detail/{postId}")
    public String detail(Model model, HttpSession session,
                         @PathVariable("postId") int id) {
        GuestUtil.checkAndSetGuestName(model, session);
        model.addAttribute("post", service.findById(id));
        return "detail";
    }

    @GetMapping("/sold/{postId}")
    public String sold(Model model, HttpSession session,
                       @PathVariable("postId") int id) {
        service.changeStatusToSold(id);
        return "redirect:/detail/" + id;
    }

    @GetMapping("/photoPost/{postId}")
    public ResponseEntity<Resource> download(@PathVariable("postId") Integer postId) {
        Post post = service.findById(postId);
        return ResponseEntity.ok()
                .headers(new HttpHeaders())
                .contentLength(post.getPhoto().length)
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new ByteArrayResource(post.getPhoto()));
    }

}
