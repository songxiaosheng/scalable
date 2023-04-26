package link.elastic.job.core;

import link.elastic.job.core.config.JobConfig;

public interface JobContainer {

    void add(JobConfig jobConfig);

    void remove(JobConfig jobConfig);


}
