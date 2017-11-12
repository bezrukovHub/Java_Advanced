package library.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.library.dao.UserDao;
import ua.com.library.entity.User;


@Component("userValidator")
public class UserValidator implements Validator {

	@Autowired
	private UserDao userDao;

	public void validate(Object object) throws Exception {
		User user = (User) object;
		
		if(user.getName().isEmpty()){
			throw new UserValidationException(UserValidationMessages.EMPTY_USERNAME_FIELD);
		}
		if(userDao.findByName(user.getName()) != null){
			throw new UserValidationException(UserValidationMessages.NAME_ALREADY_EXIST);
		}
		if(userDao.userExistsByEmail(user.getEmail())){
			throw new UserValidationException(UserValidationMessages.EMAIL_ALREADY_EXIST);
		}
		if(user.getEmail().isEmpty()){
			throw new UserValidationException(UserValidationMessages.EMPTY_EMAIl_FIELD);
		}
		if(user.getPassword().isEmpty()){
			throw new UserValidationException(UserValidationMessages.EMPTY_PASSWORD_FIELD);
		}
		if(user.getPhone().isEmpty()){
			throw new UserValidationException(UserValidationMessages.EMPTY_PHONE_FIELD);
		}
		if(userDao.findByPhone(user.getPhone()) != null){
			throw new UserValidationException(UserValidationMessages.PHONE_ALREADY_EXIST);
		}

	}
	
	

}
