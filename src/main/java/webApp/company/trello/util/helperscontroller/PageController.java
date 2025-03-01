package webApp.company.trello.util.helperscontroller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import webApp.company.trello.user.model.User;

import java.util.Objects;

@Controller
@RequestMapping("/")
public class PageController {

    @GetMapping
    public String getLoginPage() {
        return "login-page";
    }

    @GetMapping("/home-page")
    public String getHomePage(HttpSession session, Model model) {

        User user = (User) session.getAttribute("user");
        if (Objects.isNull(user)) {
            return "redirect:/";
        }

        model.addAttribute("user", user);
        return "home-page";
    }

    @GetMapping("/register")
    public String getRegisterPage() {
        return "register-page";
    }


}
