package apap.tutorial.gopud.controller;

import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.model.UserModel;
import apap.tutorial.gopud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "add/user", method = RequestMethod.POST)
    private String addUserSubmit(@ModelAttribute UserModel user) {
        userService.addUser(user);
        return "home";
    }

    @RequestMapping(value = "user/updatePassword", method = RequestMethod.GET)
    public String changePasswordUserFormPage(Model model) {
        model.addAttribute("text", "");
        model.addAttribute("navbarTitle", "Update Password");

        return "form-change-password";
    }

    @RequestMapping(value = "user/updatePassword", method = RequestMethod.POST)
    private String updatePasswordUserFormSubmit(@RequestParam String oldPass, String newPass, String confirmPass, String username, Model model){
        UserModel user = userService.getUserByUsername(username);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(encoder.matches(oldPass, user.getPassword())){
            if(newPass.equals(confirmPass)){
                userService.changePassword(user, newPass);
                model.addAttribute("teks","Password berhasil diubah");
            }
            else{
                model.addAttribute("teks", "Password baru tidak sesuai");
            }
        }
        else{
            model.addAttribute("teks", "Password lama salah");
        }
        model.addAttribute("navbarTitle", "Update Password");

        return "form-change-password";
    }

}
