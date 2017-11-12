package ua.com.library.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.com.library.dao.BookDao;
import ua.com.library.dao.BookImageDao;
import ua.com.library.entity.Book;
import ua.com.library.entity.BookImage;
import ua.com.library.service.BookImageService;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by admin on 23.12.2016.
 */
@Service
public class BookImageServiceImpl implements BookImageService {


    @Autowired
    private BookImageDao bookImageDao;
    @Autowired
    private BookDao bookDao;


    public void save(BookImage bookImage) {
        bookImageDao.save(bookImage);
    }

    public List<BookImage> findAll() {
        return bookImageDao.findAll();
    }

    public BookImage findOne(int id) {
        return bookImageDao.findOne(id);
    }

    public void delete(int id) {
        bookImageDao.delete(id);
    }


    public void saveImage(int idBook, MultipartFile[] multipartFiles) {

        Book book = bookDao.bookWithimages(idBook);

        for (MultipartFile multipartFile : multipartFiles) {


            String path = System.getProperty("catalina.home") + "/resources/" + book.getTitle() + "/"
                    + multipartFile.getOriginalFilename();

            BookImage bookImage = new BookImage("resources/" + book.getTitle() + "/" + multipartFile.getOriginalFilename());

            bookImage.setBook(book);


            File file = new File(path);

            try {
                file.mkdirs();
                multipartFile.transferTo(file);
            } catch (IOException e) {
                System.out.println("error with file");
            }

            bookImageDao.save(bookImage);


        }


    }
}
