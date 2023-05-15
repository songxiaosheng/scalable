package link.elastic.scalabel.core.bootstrap;

import link.elastic.scalabel.core.collector.H2JobCollector;
import link.elastic.scalabel.core.config.QuartzJobConfig;
import link.elastic.scalabel.core.container.DefaultJobContainer;
import link.elastic.scalabel.core.scheduler.QuartzJobScheduler;
import org.junit.jupiter.api.Test;
import org.quartz.SchedulerException;

import static org.junit.jupiter.api.Assertions.*;

class JobBootstrapTest {

    @Test
    void getInstance() {
        Bootstrap bootstrap = JobBootstrap.getInstance();
        assertNotNull(bootstrap);
    }

    @Test
    void collector() {
        Bootstrap bootstrap = JobBootstrap.getInstance();
        bootstrap.collector(new H2JobCollector());
        assertNotNull(bootstrap);
    }

    @Test
    void config() {
        Bootstrap bootstrap = JobBootstrap.getInstance();
        bootstrap.config(new QuartzJobConfig());
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
}