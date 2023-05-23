package link.elastic.scalabel.core.container;

import link.elastic.scalabel.core.config.JobConfig;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultJobContainer extends AbstractJobContainer {
    private final Set<JobConfig> jobConfigSet = ConcurrentHashMap.newKeySet();

    @Override
    public boolean add(JobConfig jobConfig) {
        return jobConfigSet.add(jobConfig);
    }

    @Override
    public boolean remove(JobConfig jobConfig) {
        return jobConfigSet.remove(jobConfig);
    }
    @Override
    public boolean exists(JobConfig jobConfig){
        return jobConfigSet.contains(jobConfig);
    }
}
