package ru.mephi.storage;

import lombok.Data;
import org.springframework.stereotype.Service;
import ru.mephi.domain.Book;

import java.util.List;

@Data
@Service
public class BooksStorage {

    private final BooksRepository booksRepository;

    public List<Book> getBooksByAuthor(String author) {
        return booksRepository.findAllByAuthor(author);
    }

    public List<Book> getBooksByName(String name) {
        return booksRepository.findAllByName(name);
    }

    public List<Book> getBooksByPublishingHouse(String ph) {
        return booksRepository.findAllByPublishingHouse(ph);
    }

    public List<Book> getBooksByLibrarySelection(String ls) {
        return booksRepository.findAllByLibrarySelection(ls);
    }

    public void saveBook(Book book) {
        booksRepository.save(book);
    }

    public void deleteByName(String name) {
        booksRepository.deleteAllByName(name);
    }

    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }

    public void addAllBooks(List b) {
        booksRepository.saveAll(b);
    }
}
