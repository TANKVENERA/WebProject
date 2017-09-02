package ru.mail.mina.web.util;

/**
 * Created by Администратор on 01.09.2017.
 */
public class Pagination {

    public static Integer startPage (Integer page) {

           Integer startpage = (page - 3 > 0 ? page - 3:1);

        return startpage;
    }
}
