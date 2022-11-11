package ru.job4j.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.model.User;
import ru.job4j.service.UserService;
import ru.job4j.util.GuestUtil;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/registration")
    public String registrationPage(Model model, HttpSession session) {
        GuestUtil.checkAndSetGuestName(model, session);
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(Model model, @ModelAttribute User user) {
        Optional<User> dbUser = service.create(user);
        if (dbUser.isEmpty()) {
            model.addAttribute("message", "Ошибка регистрации. У пользователя должен быть уникальный логин.");
        } else {
            model.addAttribute("message", "Пользователь успешно зарегистрирован");
        }
        User guestUser = new User();
        guestUser.setLogin("Гость");
        model.addAttribute("user", guestUser);
        return "registration";
    }

    @GetMapping("/login")
    public String loginPage(Model model, @RequestParam(name = "fail", required = false) Boolean fail, HttpSession session) {
        GuestUtil.checkAndSetGuestName(model, session);
        model.addAttribute("fail", fail != null);
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, HttpSession session) {
        Optional<User> dbUser = service.findByLoginAndPassword(
                user.getLogin(),
                user.getPassword());
        if (dbUser.isEmpty()) {
            return "redirect:/login?fail=true";
        }
        session.setAttribute("user", dbUser.get());
        return "redirect:/index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

}
