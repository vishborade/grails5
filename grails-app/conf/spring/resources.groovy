import com.zaxxer.hikari.HikariDataSource
import org.springframework.jdbc.core.JdbcTemplate

beans = {
    dataSource(HikariDataSource) { bean ->
        bean.destroyMethod = 'close'

        // database connection properties from DataSource.groovy
        username = "jbilling"
        password = "jbilling"
        driverClassName = "org.postgresql.Driver"
        jdbcUrl =  "jdbc:postgresql://localhost:5432/SB5"

        // Connection pooling using Hikari
        minimumIdle = 10
        maximumPoolSize = 50
        idleTimeout = 300
        connectionTimeout = 10000

        /*
           Periodically test the state of idle connections and validate connections on checkout. Handles
           potential timeouts by the database server. Increase the connection idle test period if you
           have intermittent database connection issues.
         */
        //Hikari validationTimeout can not be less than 250ms
        validationTimeout = 250
        connectionTestQuery = "/* ping */ SELECT 1"
    }

    jdbcTemplate(JdbcTemplate) {
        dataSource = ref('dataSource')
    }

    /*transactionManager (PlatformTransactionManager) {
        LocalSessionFactoryBean localSessionFactory = (LocalSessionFactoryBean)ref('localSessionFactory')
        HibernateTransactionManager transactionManager = new HibernateTransactionManager()
        transactionManager.setSessionFactory(localSessionFactory.getObject())
        return transactionManager;
    }*/

}
