package link.elastic.scalable.core.handler;

import link.elastic.scalable.core.collector.config.JobConfig;

public class NoOpJobHandler implements JobHandler{
    @Override
    public void execute(JobConfig jobConfig) {
        // do nothing
    }
}
