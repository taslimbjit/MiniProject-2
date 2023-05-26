package com.taslim.bookservice.service;

import com.taslim.bookservice.dto.BookRequest;
import com.taslim.bookservice.dto.BookResponse;
import com.taslim.bookservice.model.Book;
import com.taslim.bookservice.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {
    private final BookRepository bookRepository;

    public void createBook(BookRequest bookRequest) {
        Book book = Book.builder()
                .name(bookRequest.getName())
                .description(bookRequest.getDescription())
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
                .name(book.getName())
                .description(book.getDescription())
                .price(book.getPrice())
                .build();
    }
}
