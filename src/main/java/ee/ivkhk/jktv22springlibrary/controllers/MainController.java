package ee.ivkhk.jktv22springlibrary.controllers;

import ee.ivkhk.jktv22springlibrary.entity.Book;
import ee.ivkhk.jktv22springlibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    private BookRepository bookRepository;

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
        Book book = new Book("Voina i Mir", 2000, 2, 2, "Lev");
        bookRepository.save(book);
        return "addBook";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }
}
