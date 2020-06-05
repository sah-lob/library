package ru.mephi.storage;

import org.springframework.data.repository.CrudRepository;
import ru.mephi.domain.Book;

import java.util.List;

public interface BooksRepository extends CrudRepository<Book, Integer> {
    List<Book> findAllByAuthor(String author);
    List<Book> findAllByName(String name);
    List<Book> findAllByPublishingHouse(String ph);
    List<Book> findAllByLibrarySelection(String ls);
    List<Book> findAll();
    void deleteAllByName(String name);
}
