package ru.job4j.util;

import org.springframework.ui.Model;
import ru.job4j.model.Driver;

import javax.servlet.http.HttpSession;

public class GuestUtil {

    private GuestUtil() {
    }

    public static void checkAndSetGuestName(Model model, HttpSession session) {
        Driver driver = (Driver) session.getAttribute("driver");
        if (driver == null) {
            driver = new Driver();
            driver.setName("Гость");
        }
        model.addAttribute("driver", driver);
    }
}
