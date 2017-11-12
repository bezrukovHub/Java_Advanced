package ua.com.library.service;

import org.springframework.web.multipart.MultipartFile;
import ua.com.library.entity.Book;
import ua.com.library.entity.BookImage;

import java.util.List;

/**
 * Created by admin on 23.12.2016.
 */
public interface BookImageService {

    void save(BookImage bookImage);
    List<BookImage> findAll();
    BookImage findOne(int id);
    void delete(int id);

    void saveImage(int idBook, MultipartFile [] multipartFiles);


}
