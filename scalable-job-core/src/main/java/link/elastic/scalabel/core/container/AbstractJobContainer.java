package link.elastic.scalabel.core.container;

import link.elastic.scalabel.core.config.JobConfig;

public abstract class AbstractJobContainer implements JobContainer{

    public abstract boolean exists(JobConfig jobConfig);
}
