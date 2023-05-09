package link.elastic.scalabel.core.scheduler;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.simpl.SimpleThreadPool;
import org.quartz.plugins.management.ShutdownHookPlugin;

import java.util.Properties;

public class QuartzJobScheduler extends AbstractJobScheduler {
    private Scheduler scheduler;

    public QuartzJobScheduler() throws SchedulerException {
        scheduler = initScheduler();
        scheduler.start();
    }

    private Scheduler initScheduler() throws SchedulerException {
        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        stdSchedulerFactory.initialize(getQuartzProperties());
        return stdSchedulerFactory.getScheduler();
    }

    private String getQuartzProperties() {
        Properties properties = new Properties();
        properties.put("org.quartz.scheduler.instanceName", "ScalableJobScheduler");
        properties.put("org.quartz.threadPool.class", SimpleThreadPool.class.getName());
        //todo global quartz config
        properties.put("org.quartz.threadPool.threadCount", "10");
        properties.put("org.quartz.plugin.shutdownhook.class", ShutdownHookPlugin.class.getName());
        properties.put("org.quartz.plugin.shutdownhook.cleanShutdown", Boolean.TRUE.toString());
        return properties.toString();
    }

}
