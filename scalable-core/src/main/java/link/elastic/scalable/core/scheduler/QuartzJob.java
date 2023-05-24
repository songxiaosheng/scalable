package link.elastic.scalable.core.scheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import link.elastic.scalable.core.collector.config.JobConfig;

public class QuartzJob implements Job {
    private JobConfig jobConfig;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        jobConfig.getJobHandler().execute(jobConfig);
    }

    public JobConfig getJobConfig() {
        return jobConfig;
    }

    public void setJobConfig(JobConfig jobConfig) {
        this.jobConfig = jobConfig;
    }
}
