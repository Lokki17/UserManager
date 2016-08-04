package usermanager.controller;

import usermanager.model.User;

import java.util.List;

public class ControllerHelper {

    static final int PAGE_LENGHT = 10;

    public static List<User> getSubList(List<User> list, int currentPage){

        int maxLenght = list.size();
        int current;
        int next;

        if (currentPage * PAGE_LENGHT >= maxLenght) {
            current = maxLenght - maxLenght % PAGE_LENGHT;
            next = maxLenght;
        } else {
            current = currentPage * PAGE_LENGHT;
        }
        if (current + PAGE_LENGHT > maxLenght) {
            next = maxLenght;
        } else {
            next = current + PAGE_LENGHT;

        }

        return list.subList(current, next);
    }
}
