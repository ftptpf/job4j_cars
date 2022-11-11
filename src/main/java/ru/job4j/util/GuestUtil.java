package ru.job4j.util;

import org.springframework.ui.Model;
import ru.job4j.model.User;

import javax.servlet.http.HttpSession;

public class GuestUtil {

    private GuestUtil() {
    }

    public static void checkAndSetGuestName(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            user = new User();
            user.setLogin("Гость");
        }
        model.addAttribute("user", user);
    }
}
