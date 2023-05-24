package link.elastic.scalable.core.handler;

import link.elastic.scalable.core.collector.config.JobConfig;

public interface JobHandler {
    void execute(JobConfig jobConfig);
}
