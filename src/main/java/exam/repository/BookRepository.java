package exam.repository;

import exam.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    public List<Book> findAll();
    public List<Book> findByTitle(String title);
    public void deleteByTitle(String title);
}
