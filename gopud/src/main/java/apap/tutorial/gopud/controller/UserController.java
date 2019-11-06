package apap.tutorial.gopud.controller;

import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.model.UserModel;
import apap.tutorial.gopud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "add/user", method = RequestMethod.POST)
    private String addUserSubmit(@ModelAttribute UserModel user) {
        userService.addUser(user);
        return "home";
    }

    @RequestMapping(value = "user/update", method = RequestMethod.GET)
    public String changePasswordUserFormPage(@PathVariable Long id, Model model) {
        UserModel existing = userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("user", existing);
        model.addAttribute("navbarTitle", "Update Password");

        return "form-change-password";
    }

    @RequestMapping(value = "user/update", method = RequestMethod.POST)
    public String changePasswordUserFormSubmit(@PathVariable Long id, @ModelAttribute UserModel user, Model model) {
        UserModel newPassword = userService.changePassword(user);
        model.addAttribute("user", newPassword);

        return "change-password";
    }

}
