package ua.com.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.library.entity.BookImage;

/**
 * Created by admin on 23.12.2016.
 */
public interface BookImageDao extends JpaRepository<BookImage, Integer> {
}
