package ru.mail.mina.repository;

import org.apache.log4j.BasicConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.mail.mina.repository.dao.UserGenericHibernateDao;
import ru.mail.mina.repository.model.*;



/**
 * Created by Администратор on 12.07.2017.
 */
public class Runner {
    public static void main(String[] args) {
        BasicConfigurator.configure();

      ApplicationContext context = new
              ClassPathXmlApplicationContext("spring-config.xml");
    //    System.out.println(context.getBean("userDao"));

        User user = new User();
       user.setEmail("Mina@");
       user.setPassword("123456");
       user.setUsername("friva");
        UserGenericHibernateDao userDao = (UserGenericHibernateDao) context.getBean("userDao");

        userDao.insert(user);

   }
}
