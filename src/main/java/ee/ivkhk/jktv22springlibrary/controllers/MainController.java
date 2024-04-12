package ee.ivkhk.jktv22springlibrary.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "JKTV22-SpringLibrary");
        model.addAttribute("caption", "Welcome to our library");
        return "home";
    }

    @GetMapping("/book")
    public String getBook(Model model) {
        model.addAttribute("title", "Opened: ");
        model.addAttribute("caption", "Book 1");
        model.addAttribute("result", HttpStatus.OK);
        return "addBook";
    }

    @PostMapping("/book")
    public String addBook(@RequestParam String caption ,Model model) {
        model.addAttribute("title", "Adding a book");
        model.addAttribute("caption", caption);
        model.addAttribute("result", HttpStatus.OK);
        return "addBook";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }
}
