package ru.mephi.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.web.bind.annotation.*;
import ru.mephi.domain.Book;
import ru.mephi.storage.BooksStorage;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@org.springframework.stereotype.Controller
@Data
public class Controller {

    private final BooksStorage booksStorage;

    @GetMapping(value = "/author")
    public void getBooksByAuthor(@RequestParam(name = "author") String author, HttpServletResponse resp) throws IOException {
        answer(resp, booksStorage.getBooksByAuthor(author), author);
    }

    @GetMapping(value = "/name")
    public void getBooksByName(@RequestParam(name = "name") String name, HttpServletResponse resp) throws IOException {
        answer(resp, booksStorage.getBooksByName(name), name);
    }

    @GetMapping(value = "/publishingHouse")
    public void getBooksByPublishingHouse(@RequestParam(name = "publishingHouse") String publishingHouse, HttpServletResponse resp) throws IOException {
        answer(resp, booksStorage.getBooksByPublishingHouse(publishingHouse), publishingHouse);
    }


    @GetMapping(value = "/librarySelection")
    public void getBooksByLibrarySelection(@RequestParam(name = "librarySelection") String librarySelection, HttpServletResponse resp) throws IOException {
        answer(resp, booksStorage.getBooksByLibrarySelection(librarySelection), librarySelection);
    }


    @PostMapping(value = "/editBook")
    public void editBook(@RequestBody Book book) {
        booksStorage.saveBook(book);
    }


    @PostMapping(value = "/addBook")
    public void addBook(@RequestBody Book book) {
        booksStorage.saveBook(book);
    }

    @DeleteMapping(value = "/deleteBookByName")
    public void deleteBook(@RequestParam(name = "name") String name) {
        booksStorage.deleteByName(name);
    }

    @GetMapping(value = "/saveAll")
    public List saveAll() throws IOException {
        return booksStorage.getAllBooks();
    }

    @PostMapping(value = "/addAll")
    public void addAll(@RequestBody List<Book> books) {
        booksStorage.addAllBooks(books);
    }


    private void answer(HttpServletResponse resp, List<Book> booksByName, @RequestParam(name = "name") String name) throws IOException {
        resp.setContentType("text/json");
        resp.setCharacterEncoding("Cp1251");
        var pw = resp.getWriter();
        var k = booksByName;
        var objectMapper = new ObjectMapper();
        var json = objectMapper.writeValueAsString(k);
        pw.append(objectMapper.writeValueAsString(json));
        pw.flush();
    }
}
