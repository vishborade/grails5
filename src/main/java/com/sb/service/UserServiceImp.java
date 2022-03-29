package com.sb.service;

import org.springframework.stereotype.Service;
import com.sb.dao.UserDao;
import com.sb.model.User;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.context.ApplicationContext;

@Service
@Transactional(transactionManager="transactionManager", propagation = Propagation.REQUIRED)
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Autowired
   private ApplicationContext appContext;

   public void save(User user) {

      Object obj = appContext.getBean("transactionManager");
      System.out.println("transactionManager = " + obj);

      userDao.save(user);
   }

   @Transactional(readOnly = true)
   public List<User> list() {
      return userDao.list();
   }
}