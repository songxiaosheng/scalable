package link.elastic.scalable.core.bootstrap;

import link.elastic.scalable.core.collector.H2JobCollector;
import link.elastic.scalable.core.container.DefaultJobContainer;
import link.elastic.scalable.core.scheduler.QuartzJobScheduler;
import org.junit.jupiter.api.Test;
import org.quartz.SchedulerException;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class JobBootstrapTest {

    @Test
    void getInstance() {
        Bootstrap bootstrap = JobBootstrap.getInstance();
        assertNotNull(bootstrap);
    }

    @Test
    void collector() throws SQLException, ClassNotFoundException {
        Bootstrap bootstrap = JobBootstrap.getInstance();
        bootstrap.collector(new H2JobCollector());
        assertNotNull(bootstrap);
    }


    @Test
    void container() {
        Bootstrap bootstrap = JobBootstrap.getInstance();
        bootstrap.container(new DefaultJobContainer());
        assertNotNull(bootstrap);
    }

    @Test
    void scheduler() throws SchedulerException {
        Bootstrap bootstrap = JobBootstrap.getInstance();
        bootstrap.scheduler(new QuartzJobScheduler());
        assertNotNull(bootstrap);
    }

    @Test
    void bootstrapJob() throws SchedulerException, SQLException, ClassNotFoundException {
        JobBootstrap.getInstance()
                .collector(new H2JobCollector())
                .container(new DefaultJobContainer())
                .scheduler(new QuartzJobScheduler());
    }
}