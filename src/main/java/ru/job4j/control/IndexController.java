package ru.job4j.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.service.PostService;
import ru.job4j.util.GuestUtil;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    private final PostService service;

    public IndexController(PostService service) {
        this.service = service;
    }

    @GetMapping("/index")
    public String index(Model model, HttpSession session) {
        GuestUtil.checkAndSetGuestName(model, session);
        model.addAttribute("items", service.findAll());
        return "index";
    }
}
