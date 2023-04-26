package link.elastic.job.core.container;

import link.elastic.job.core.JobContainer;
import link.elastic.job.core.config.JobConfig;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class DefaultJobContainer implements JobContainer {
    private final List<JobConfig> jobConfigMap = new CopyOnWriteArrayList<>();
    @Override
    public void add(JobConfig jobConfig) {
        jobConfigMap.add(jobConfig);
    }

    @Override
    public void remove(JobConfig jobConfig) {
        jobConfigMap.remove(jobConfig);
    }
}
