package link.elastic.scalabel.core.bootstrap;

import link.elastic.scalabel.core.collector.JobCollector;
import link.elastic.scalabel.core.config.JobConfig;
import link.elastic.scalabel.core.container.JobContainer;
import link.elastic.scalabel.core.scheduler.JobScheduler;

public class JobBootstrap implements Bootstrap {
    private static final JobBootstrap jobBootstrap = new JobBootstrap();
    private static JobCollector collector;
    private JobConfig config;
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
    public JobBootstrap config(JobConfig config) {
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
