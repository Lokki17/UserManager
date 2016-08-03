package usermanager.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import usermanager.model.User;
import usermanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class UserController {
    private UserService userService;

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", this.userService.listUsers());

        return "users";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user) {
        if (user.getId() == 0) {
            this.userService.addUser(user);
        } else {
            this.userService.updateUser(user);
        }

        return "redirect:/users";
    }

    @RequestMapping("/remove/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        this.userService.removeUser(id);

        return "redirect:/users";
    }

    @RequestMapping("edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", this.userService.getUser(id));
        model.addAttribute("listUsers", this.userService.listUsers());

        return "users";
    }

    @RequestMapping("userdata/{id}")
    public String userData(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", this.userService.getUser(id));

        return "userdata";
    }

    @RequestMapping(value = "users/filter")
    @Transactional
    public String sortedList(String name, Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("filterUsers", this.userService.filterList(name));

        return "filterUsers";
    }

    @RequestMapping(value = "editOneUser/{id}")
    public String edtiOneUser(@PathVariable("id") int id, Model model) {
        User user = this.userService.getUser(id);
        //model.addAttribute("user", this.userService.getUser(id));
        model.addAttribute("user", user);
/*        model.addAttribute("listUsers", this.userService.listUsers());*/

        return "edtiUser";
    }
}
