package link.elastic.scalabel.core.handler;

import link.elastic.scalabel.core.config.JobConfig;

public interface JobHandler {
        void execute(JobConfig jobConfig);
}
