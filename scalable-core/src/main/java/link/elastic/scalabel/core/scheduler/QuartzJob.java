package link.elastic.scalabel.core.scheduler;

import link.elastic.scalabel.core.config.JobConfig;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

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
