package dao;

import com.mchange.util.impl.CircularListQueue;
import dao.BookDao;
import model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class BookDaoImp implements BookDao {

    @Autowired
    SessionFactory sessionFactory;

    public long save(Book book) {
        sessionFactory.getCurrentSession().save(book);
        return book.getId();
    }

    public Book get(long id) {
        return sessionFactory.getCurrentSession().get(Book.class,id);
    }

    public List<Book> list() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root root = criteriaQuery.from(Book.class);
        criteriaQuery.select(root);
        Query<Book> query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }

    public void update(long id, Book book) {

    }

    public void delete(long id) {

    }
}
