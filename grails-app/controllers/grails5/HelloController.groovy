package grails5

import com.sb.service.UserService
import helloworld.Person
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import com.sb.model.User
import org.springframework.context.ApplicationContext;

class HelloController {

    @Autowired
    UserService userService

    @Autowired
    private ApplicationContext appContext;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    def index() {

        def sessionFactory = appContext.getBean("sessionFactory")
        println "@@@@@@@@@@@ sessionFactory = " + sessionFactory
        def transactionManager = appContext.getBean("transactionManager")
        println "@@@@@@@@@@@ transactionManager = " + transactionManager

        Person.list().collect { Person p ->
            System.out.println ("@@@@@@@@@ GORM = " + "$p.firstName $p.lastName")
            println "$p.firstName $p.lastName".toString()
        }

        //userService.list()

        User user = new User()
        user.setName("Test1")
        user.setEmail("test@test.com");
        userService.save(user)

        render "Hello World!"
    }
}
