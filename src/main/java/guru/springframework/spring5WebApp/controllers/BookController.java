package guru.springframework.spring5WebApp.controllers;

import guru.springframework.spring5WebApp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping(name = "/books")
    public String getBooks (Model bookModel) {
        bookModel.addAttribute("books", bookRepository.findAll());
        return "books/listOfBooks";
    }

}

