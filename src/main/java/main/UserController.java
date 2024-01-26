package main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "people")
public class UserController {

    private Storage storage = new Storage();

    @PostMapping("/save")
    public String addUser(User user) {
        System.out.println("Попали в post метод");
        System.out.println("Объект - " + user.getUsername());
        storage.addUser(user);
        return "redirect:/people/list";
    }

    @GetMapping("/list")
    public String getUsers(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("userList", storage.users);
        return "index";
    }


}
