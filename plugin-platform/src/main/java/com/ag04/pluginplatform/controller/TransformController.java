package com.ag04.pluginplatform.controller;

import com.ag04.pluginplatform.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transform")
@RequiredArgsConstructor
public class TransformController {

    @GetMapping
    public Book transform() {
        Book book = new Book();
        book.setTitle("The Hobbit");
        book.setAuthor("J.R.R. Tolkien");
        book.setIsbn("978-0547928227");
        return book;
    }


}
