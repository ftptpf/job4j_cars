package ru.job4j.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.model.Driver;
import ru.job4j.service.DriverService;
import ru.job4j.util.GuestUtil;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class DriverController {

    private final DriverService service;

    public DriverController(DriverService service) {
        this.service = service;
    }

    @GetMapping("/registration")
    public String registrationPage(Model model, HttpSession session) {
        GuestUtil.checkAndSetGuestName(model, session);
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(Model model, @ModelAttribute Driver driver) {
        Optional<Driver> dbUser = service.create(driver);
        if (dbUser.isEmpty()) {
            model.addAttribute("message", "Ошибка регистрации. У пользователя должен быть уникальный логин.");
        } else {
            model.addAttribute("message", "Пользователь успешно зарегистрирован");
        }
        Driver guestDriver = new Driver();
        guestDriver.setName("Гость");
        model.addAttribute("driver", guestDriver);
        return "registration";
    }

    @GetMapping("/login")
    public String loginPage(Model model, @RequestParam(name = "fail", required = false) Boolean fail, HttpSession session) {
        GuestUtil.checkAndSetGuestName(model, session);
        model.addAttribute("fail", fail != null);
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Driver driver, HttpSession session) {
        List<Driver> list = service.findByLoginAndPassword(
                driver.getEmail(),
                driver.getPassword());
        if (list.isEmpty()) {
            return "redirect:/login?fail=true";
        }
        Driver driverDb = list.get(0);
        session.setAttribute("driver", driverDb);
        return "redirect:/index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }



}
