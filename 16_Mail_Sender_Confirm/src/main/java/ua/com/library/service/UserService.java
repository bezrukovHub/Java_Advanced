package ua.com.library.service;

import java.security.Principal;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.web.multipart.MultipartFile;
import ua.com.library.entity.User;

public interface UserService {

    void save(User user) throws Exception;

    List<User> findAll();

    User findOne(int id);

    void delete(int id);

    void buyBook(Principal principal, String id);

    public void saveImage(Principal principal, MultipartFile multipartFile);

    User fetchUserWithBook(int id);



    User findByUUID(String uuid);

    void update(User user);


}
