package com.taslim.bookservice.service;

import com.taslim.bookservice.dto.BookRequest;
import com.taslim.bookservice.dto.BookResponse;
import com.taslim.bookservice.model.Book;
import com.taslim.bookservice.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {
    private final BookRepository bookRepository;

    public void createBook(BookRequest bookRequest) {
        Book book = Book.builder()
                .bookName(bookRequest.getBookName())
                .authorName(bookRequest.getAuthorName())
                .price(bookRequest.getPrice())
                .build();

        bookRepository.save(book);
        log.info("Book {} is saved", book.getId());
    }

    public List<BookResponse> getAllBooks() {
        List<Book> books = bookRepository.findAll();

        return books.stream().map(this::mapToBookResponse).toList();
    }

    private BookResponse mapToBookResponse(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .bookName(book.getBookName())
                .authorName(book.getAuthorName())
                .price(book.getPrice())
                .build();
    }


}
