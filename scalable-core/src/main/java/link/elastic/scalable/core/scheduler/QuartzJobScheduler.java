package link.elastic.scalable.core.scheduler;

import link.elastic.scalable.core.collector.config.JobConfig;
import link.elastic.scalable.core.collector.config.QuartzJobConfig;
import link.elastic.scalable.core.config.ScalableConfig;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.simpl.SimpleThreadPool;
import org.quartz.plugins.management.ShutdownHookPlugin;

import java.util.Properties;

public class QuartzJobScheduler extends AbstractJobScheduler {
    private Scheduler scheduler;

    public QuartzJobScheduler() throws SchedulerException {
        scheduler = initScheduler();

    }
    @Override
    public void start() {
        try {
            scheduler.start();
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

    private Scheduler initScheduler() throws SchedulerException {
        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        stdSchedulerFactory.initialize(getQuartzProperties());
        return stdSchedulerFactory.getScheduler();
    }

    private Properties getQuartzProperties() {
        Properties properties = new Properties();
        properties.put("org.quartz.scheduler.instanceName", "ScalableJobScheduler");
        properties.put("org.quartz.threadPool.class", SimpleThreadPool.class.getName());
        //todo global quartz config and use config
        properties.put("org.quartz.threadPool.threadCount", "10");
        properties.put("org.quartz.plugin.shutdownhook.class", ShutdownHookPlugin.class.getName());
        properties.put("org.quartz.plugin.shutdownhook.cleanShutdown", Boolean.TRUE.toString());
        return properties;
    }

    public void addJobConfig(JobConfig jobConfig) throws SchedulerException {
        if (jobConfig == null) {
            return;
        }
        if (!(jobConfig instanceof QuartzJobConfig)) {
            return;
        }
        QuartzJobConfig quartzJobConfig = (QuartzJobConfig) jobConfig;

        JobKey jobKey = JobKey.jobKey(quartzJobConfig.getJobName());
        if (scheduler.checkExists(jobKey)) {
            return;
        }

        JobDetail jobDetail = JobBuilder.newJob(QuartzJob.class)
                .withIdentity(jobKey)
                .build();
        jobDetail.getJobDataMap().put("jobConfig", jobConfig);
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity(quartzJobConfig.getCron())
                .withSchedule(CronScheduleBuilder.cronSchedule(quartzJobConfig.getCron())).build();
        scheduler.scheduleJob(jobDetail, cronTrigger);
    }

}
