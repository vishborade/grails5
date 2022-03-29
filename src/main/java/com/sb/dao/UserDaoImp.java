package com.sb.dao;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.SessionFactory;
import com.sb.model.User;
import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;
    //private LocalSessionFactoryBean localSessionFactory;

    @Override
    public void save(User user) {
        java.util.Set<javax.persistence.metamodel.EntityType<?>> entities = sessionFactory.getMetamodel().getEntities();
        List<?> classes = entities.stream()
                .map(it -> it.getName())
                .filter(java.util.Objects::nonNull)
                .collect(java.util.stream.Collectors.toList());
        System.out.println ("@@@@@@ Mapped entities = " + classes);

        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public List<User> list() {
        @SuppressWarnings("unchecked")
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User u");
        return query.getResultList();
    }
}