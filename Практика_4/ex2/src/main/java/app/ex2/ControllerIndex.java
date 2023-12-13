package app.ex2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;

@Controller
public class ControllerIndex {
    @Autowired
    ElementRepository elementRepository;

    @GetMapping("/")
    public String index(Model model) throws IOException {
        model.addAttribute("namePage", "Главная");
        return "index";
    }

    @GetMapping("/add")
    public String addGet(Model model) throws IOException {
        model.addAttribute("namePage", "Добавление");
        return "index";
    }

    @PostMapping("/add")
    public String addPost(Model model, @RequestParam String title) throws IOException {
        elementRepository.save(new Element(title));
        return "redirect:/get";
    }

    @GetMapping("/get")
    public String get(Model model) throws IOException {
        model.addAttribute("namePage", "Вывод");
        model.addAttribute("Elements", elementRepository.findAll());
        return "index";
    }
}
