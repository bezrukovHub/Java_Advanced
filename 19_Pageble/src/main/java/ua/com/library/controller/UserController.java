package ua.com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.com.library.dto.DtoUtilMapper;
import ua.com.library.entity.User;
import ua.com.library.service.MailSenderService;
import ua.com.library.service.UserService;
import ua.com.library.validator.UserValidationMessages;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Scanner;
import java.util.UUID;

@Controller
public class UserController {


    @Autowired
    @Qualifier("userDetailsService")
    private UserService userService;

    @Autowired
    private MailSenderService mailSenderService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String newUser(Model model) {
//        model.addAttribute("userDTOs", DtoUtilMapper.usersToUsersDTO(userService.findAll()));

        return "views-user-registration";
    }


    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
    public String newUser(@PathVariable int id) {

        userService.delete(id);

        return "redirect:/registration";
    }

   

    @RequestMapping(value = "/saveImage", method = RequestMethod.POST)
    public String saveImage(Principal principal,
                            @RequestParam MultipartFile image) {

        userService.saveImage(principal, image);

        return "redirect:/profile";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(HttpServletRequest request, Principal principal, Model model) {

        User user = userService.fetchUserWithBook(Integer.parseInt(principal.getName()));

        model.addAttribute("user", user);

        return "views-user-profile";
    }


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute User user, Model model) {

        String uuid = UUID.randomUUID().toString();

        user.setUuid(uuid);

        try {
            userService.save(user);
        } catch (Exception e) {
            if (e.getMessage().equals(UserValidationMessages.EMPTY_USERNAME_FIELD) ||
                    e.getMessage().equals(UserValidationMessages.NAME_ALREADY_EXIST)) {
                model.addAttribute("usernameException", e.getMessage());
            } else if (e.getMessage().equals(UserValidationMessages.EMPTY_EMAIl_FIELD) ||
                    e.getMessage().equals(UserValidationMessages.EMAIL_ALREADY_EXIST)) {
                model.addAttribute("emailException", e.getMessage());
            } else if (e.getMessage().equals(UserValidationMessages.EMPTY_PASSWORD_FIELD)) {
                model.addAttribute("passwordException", e.getMessage());
            } else if (e.getMessage().equals(UserValidationMessages.EMPTY_PHONE_FIELD) ||
                    e.getMessage().equals(UserValidationMessages.PHONE_ALREADY_EXIST)) {
                model.addAttribute("phoneException", e.getMessage());
            }
            return "views-user-registration";
        }

        String theme = "thank's for registration";
        String mailBody =
                "gl & hf       http://localhost:8080/confirm/" + uuid;

        mailSenderService.sendMail(theme, mailBody, user.getEmail());

        return "redirect:/";
    }

    @RequestMapping(value = "/confirm/{uuid}", method = RequestMethod.GET)
    public String confirm(@PathVariable String uuid) {

        try{



        }catch (ArrayIndexOutOfBoundsException w){

        }finally {
            System.out.println();
        }





        User user = userService.findByUUID(uuid);
        user.setEnabled(true);

        userService.update(user);

        return "redirect:/";
    }

    @RequestMapping(value = "/updateProfile", method = RequestMethod.GET)
    public String updateProfile(Principal principal, Model model){
        User user = userService.findOne(Integer.parseInt(principal.getName()));
        model.addAttribute("user", user);
        return "views-user-updateProfile";
    }

    @RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
    public String updateProfile(Principal principal, @RequestParam String name,
                                @RequestParam String email,
                                @RequestParam String phone,
                                @RequestParam String password){
        User user = userService.findOne(Integer.parseInt(principal.getName()));

        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPassword(password);

        userService.updateProfile(user);

        return "redirect:/profile";
    }



    @RequestMapping(value = "joinUserWhithBook/{idBook}", method = RequestMethod.PUT)
    public String join(Principal principal, @PathVariable String idBook){

        userService.join(Integer.parseInt(principal.getName()),Integer.parseInt(idBook));


        return null;
    }



}
