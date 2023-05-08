package link.elastic.job.core.container;

import link.elastic.job.core.config.JobConfig;

public interface JobContainer {

    void add(JobConfig jobConfig);

    void remove(JobConfig jobConfig);


}
