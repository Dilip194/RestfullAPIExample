package dao;

import model.Book;

import java.util.List;

public interface BookDao {

    long save(Book book);
    Book get(long id);
    List<Book> list();
    void update(long id,Book book);
    void delete(long id);
}
