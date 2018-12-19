package exam.controller;

import exam.dto.BookDto;
import exam.services.BookService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@Api(value="books")
public class BookController {

    @Autowired
    private BookService bookService;

    public BookController(BookService bookService) {

        this.bookService = bookService;
    }

    public BookService getBookService() {

        return bookService;
    }

    public void setBookService(BookService bookService) {

        this.bookService = bookService;
    }


    @RequestMapping(value="/all", method=RequestMethod.GET)
    public Collection<BookDto> getAllBooks(){
        return bookService.getAllBooks();
    }

    @RequestMapping(value="/filter/{title}", method=RequestMethod.GET)
    public Collection<BookDto> findBookByTitle(@PathVariable("title")String title){
        return bookService.getBookByTitle(title);
    }

    @RequestMapping(value="/add", method=RequestMethod.POST)
    public void addNewBook(@RequestBody BookDto bookDto){
        bookService.addBook(bookDto);
    }


    @RequestMapping(value="/update/{title}", method=RequestMethod.PUT)
    public void updateBook(@PathVariable("title")String title,@RequestBody BookDto bookDto){
       bookService.updateBookByTitle(title, bookDto);
    }

    @RequestMapping(value="/delete/{title}", method=RequestMethod.DELETE)
    public void deleteBook(@PathVariable("title")String title){
        bookService.deleteBookByTitle(title);
    }

}
