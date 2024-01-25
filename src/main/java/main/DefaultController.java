package main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class DefaultController {

    @GetMapping
    public String index(Model model) {
        model.addAttribute("pageTitle", "Hello Nikita! Below, list with your friends:");
        model.addAttribute("scientists", List.of("Nikita", "Anton", "Kirill"));

        return "index";
    }
}
