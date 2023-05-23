package link.elastic.scalabel.core.handler;

import link.elastic.scalabel.core.config.JobConfig;

public class NoOpJobHandler implements JobHandler{
    @Override
    public void execute(JobConfig jobConfig) {
        // do nothing
    }
}
