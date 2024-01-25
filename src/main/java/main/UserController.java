package main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private Storage storage = new Storage();

    @PostMapping("/users")
    public String addUser(User user) {
        System.out.println("Попали в post метод");
        System.out.println(user.getUsername());
        storage.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/")
    public String getUsers(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("user-name", storage.users.get(0).getUsername());
        model.addAttribute("user-age", storage.users.get(0).getAge());
        return "index";
    }


}
