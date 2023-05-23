package link.elastic.scalabel.core.container;

import link.elastic.scalabel.core.config.JobConfig;

public interface JobContainer {

    boolean add(JobConfig jobConfig);

    boolean remove(JobConfig jobConfig);


}
