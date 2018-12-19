package exam.loader;

import exam.entities.Book;
import exam.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LoaderIntoRepository implements CommandLineRunner {

    @Autowired
    private final BookRepository bookRepository;


    public LoaderIntoRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//       Book book1=new Book("Fly over cockoo's nest", "Ivan Kirsanov", "blabla", 5);
//       Book book2=new Book("Lotr-1", "Tolkien", "blabla", 5);
//       Book book3=new Book("Lotr-2", "Molkien", "blabla", 4);
//
//
//       bookRepository.save(book1);
//       bookRepository.save(book2);
//       bookRepository.save(book3);
    }
}
