package main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "people")
public class UserController {


    private Storage storage = new Storage();


    @PostMapping("/save")
    public String addUser(User user) {
        System.out.println("метод POST");
        System.out.println("объект: '" + user.getUsername() + "' сохранен");
        storage.addUser(user);



        return "redirect:/people/list";
    }


    @GetMapping("/list")
    public String getUsers(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("userList", storage.getAllUsers());
        return "index";
    }


    @PostMapping(value = "/remove")
    public String remove(@RequestParam(value = "userIdToRemove") Integer userIdToRemove) {
        System.out.println("remove controller into");
        if (storage.removeUser(userIdToRemove)) {
            return "redirect:/people/list";
        } else {
            return "index";
        }
    }

}
