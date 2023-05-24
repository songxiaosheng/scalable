package link.elastic.scalable.core.bootstrap;

import link.elastic.scalable.core.collector.JobCollector;
import link.elastic.scalable.core.config.ScalableConfig;
import link.elastic.scalable.core.container.JobContainer;
import link.elastic.scalable.core.scheduler.JobScheduler;

public interface Bootstrap {
    Bootstrap collector(JobCollector collector);

    Bootstrap config(ScalableConfig config);

    Bootstrap container(JobContainer container);

    Bootstrap scheduler(JobScheduler scheduler);

    void start();
}
