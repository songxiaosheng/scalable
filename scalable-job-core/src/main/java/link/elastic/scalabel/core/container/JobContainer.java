package link.elastic.scalabel.core.container;

import link.elastic.scalabel.core.config.JobConfig;

public interface JobContainer {

    void add(JobConfig jobConfig);

    void remove(JobConfig jobConfig);


}
