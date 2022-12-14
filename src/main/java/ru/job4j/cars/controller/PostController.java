package ru.job4j.cars.controller;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.job4j.cars.model.Post;
import ru.job4j.cars.model.User;
import ru.job4j.cars.service.*;
import ru.job4j.cars.util.GuestUtil;
import ru.job4j.cars.model.Car;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;

@Controller
public class PostController {

    private final PostService service;
    private final UserService userService;
    private final BodyService bodyService;
    private final BrandService brandService;
    private final EngineService engineService;
    private final CarService carService;

    public PostController(PostService service,
                          UserService userService,
                          BodyService bodyService,
                          BrandService brandService,
                          EngineService engineService,
                          CarService carService) {
        this.service = service;
        this.userService = userService;
        this.bodyService = bodyService;
        this.brandService = brandService;
        this.engineService = engineService;
        this.carService = carService;
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
        model.addAttribute("bodies", bodyService.findAll());
        model.addAttribute("brands", brandService.findAll());
        model.addAttribute("engines", engineService.findAll());
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
        post.setCreated(LocalDateTime.now());
        carService.saveOrUpdate(car);
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
