package link.elastic.scalabel.core.config;

import link.elastic.scalabel.core.handler.JobHandler;

public abstract class AbstractJobConfig implements JobConfig{

    private String jobName;
    private JobHandler jobHandler;

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public JobHandler getJobHandler() {
        return jobHandler;
    }

    public void setJobHandler(JobHandler jobHandler) {
        this.jobHandler = jobHandler;
    }
}
