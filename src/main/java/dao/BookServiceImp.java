package dao;

import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.BookService;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BookServiceImp implements BookService {

    @Autowired
    BookDao bookDao;

    public long save(Book book) {
        return bookDao.save(book);
    }

    public Book get(long id) {
        return bookDao.get(id);
    }

    public List<Book> list() {
        return bookDao.list();
    }

    public void update(long id, Book book) {

    }

    public void delete(long id) {

    }
}
