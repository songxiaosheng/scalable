package link.elastic.scalable.core.scheduler;

import link.elastic.scalable.core.collector.config.QuartzJobConfig;
import org.junit.jupiter.api.Test;
import org.quartz.SchedulerException;

import java.util.Date;

class QuartzJobSchedulerTest {

    @Test
    void addJobConfig() throws SchedulerException, InterruptedException {
        QuartzJobConfig jobConfig = new QuartzJobConfig();
        jobConfig.setJobName("test");
        jobConfig.setCron("0/5 * * * * ?");
        jobConfig.setJobHandler((jobConfigParam) -> System.out.println(new Date().toString() + "test" + jobConfigParam.toString()));
        new QuartzJobScheduler().addJobConfig(jobConfig);

        QuartzJobConfig jobConfig2 = new QuartzJobConfig();
        jobConfig2.setJobName("test2");
        jobConfig2.setCron("0/8 * * * * ?");
        jobConfig2.setJobHandler((jobConfigParam) -> System.out.println(new Date().toString() + "test2" + jobConfigParam.toString()));
        new QuartzJobScheduler().addJobConfig(jobConfig2);
        Thread.sleep(60 * 1000);
    }
}