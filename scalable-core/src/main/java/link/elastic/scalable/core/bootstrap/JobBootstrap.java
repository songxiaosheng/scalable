package link.elastic.scalable.core.bootstrap;

import link.elastic.scalable.core.collector.JobCollector;
import link.elastic.scalable.core.config.ScalableConfig;
import link.elastic.scalable.core.container.JobContainer;
import link.elastic.scalable.core.scheduler.JobScheduler;

public class JobBootstrap implements Bootstrap {
    private static final JobBootstrap jobBootstrap = new JobBootstrap();
    private static JobCollector collector;
    private ScalableConfig config;
    private JobContainer container;
    private JobScheduler scheduler;

    private JobBootstrap() {
    }

    public static JobBootstrap getInstance() {
        return jobBootstrap;
    }

    @Override
    public  JobBootstrap collector(JobCollector collector) {
        this.collector = collector;
        return this;
    }
    @Override
    public JobBootstrap config(ScalableConfig config) {
        this.config = config;
        return this;
    }
    @Override
    public JobBootstrap container(JobContainer container) {
        this.container = container;
        return this;
    }
    @Override
    public JobBootstrap scheduler(JobScheduler scheduler){
        this.scheduler = scheduler;
        return this;
    }

    @Override
    public void start() {
        this.scheduler.start();
    }


}
