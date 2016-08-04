package usermanager.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import usermanager.model.User;
import usermanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    //private int currentPage = 0;
    private int currentPage = 0;
    //private int pageLenght = 10;
    private int maxLenght;

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    @Transactional
    public String listUsers(Model model) {
        List<User> list = this.userService.listUsers();
        this.maxLenght = list.size();
/*        int current = 0, next = pageLenght;
        this.maxLenght = list.size();
        if (currentPage * pageLenght >= maxLenght) {
            current = maxLenght - maxLenght % pageLenght;
            next = maxLenght;
        } else {
            current = currentPage * pageLenght;
        }
        if (current + pageLenght > maxLenght) {
            next = maxLenght;
        } else {
            next = current + pageLenght;

        }

        List<User> result = list.subList(current, next);
        */


        List<User> result = ControllerHelper.getSubList(list, currentPage);
/*        System.out.println("currentPage = " + currentPage);
        System.out.println("current = " + current);
        System.out.println("next = " + next);
        System.out.println("result.size = " + result.size());
        System.out.println();*/

        model.addAttribute("user", new User());
        model.addAttribute("listUsers", result);

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
        List<User> list = ControllerHelper.getSubList(this.userService.listUsers(), currentPage);
        model.addAttribute("listUsers", list);

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
    @Transactional
    public String edtiOneUser(@PathVariable("id") int id, Model model) {
        User user = this.userService.getUser(id);
        model.addAttribute("user", user);

        return "edtiUser";
    }

    @RequestMapping(value = "users/nextUserPage")
    @Transactional
    public String nextUserPage() {
        int pageLenght = ControllerHelper.PAGE_LENGHT;
        if (currentPage * pageLenght < maxLenght - pageLenght) {
            currentPage++;
        }
        return "redirect:/users";
    }

    @RequestMapping(value = "users/prevUserPage")
    @Transactional
    public String prevUserPage() {
        if (currentPage > 0) {
            currentPage--;
        }
        return "redirect:/users";
    }
}
