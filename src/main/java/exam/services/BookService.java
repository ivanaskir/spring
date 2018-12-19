package exam.services;

import exam.dto.BookDto;
import exam.entities.Book;
import exam.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public List<BookDto> getAllBooks() {
        return bookRepository.findAll().stream().map(book->
                new BookDto(book.getTitle(),
                book.getAuthor(),
                book.getDescription(),
                book.getPublished()))
                .collect(Collectors.toList());
    }

    @Transactional
    public void addBook(BookDto bookDto) {
        Book book=new Book(bookDto.getTitle(),bookDto.getAuthor(),bookDto.getDescription(), bookDto.getPublished());
        bookRepository.save(book);
    }

    @Transactional
    public Collection<BookDto> getBookByTitle(String title) {
        return bookRepository.findByTitle(title).stream().map(book ->
                new BookDto(book.getTitle(),book.getAuthor(),
                        book.getDescription(),book.getPublished()))
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateBookByTitle(String title, BookDto bookDto) {
        Book savedBook=bookRepository.findByTitle(title).get(0);
        savedBook.setTitle(bookDto.getTitle());
        savedBook.setAuthor(bookDto.getAuthor());
        savedBook.setDescription(bookDto.getDescription());
        savedBook.setPublished(bookDto.getPublished());
        Book updateBook=bookRepository.save(savedBook);
    }

    @Transactional
    @Modifying
    public void deleteBookByTitle(String title) {
        bookRepository.deleteByTitle(title);
    }
}


