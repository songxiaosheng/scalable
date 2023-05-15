package link.elastic.scalabel.core.bootstrap;

import link.elastic.scalabel.core.collector.JobCollector;
import link.elastic.scalabel.core.config.JobConfig;
import link.elastic.scalabel.core.container.JobContainer;
import link.elastic.scalabel.core.scheduler.JobScheduler;

public interface Bootstrap {
    Bootstrap collector(JobCollector collector);

    Bootstrap config(JobConfig config);

    Bootstrap container(JobContainer container);

    Bootstrap scheduler(JobScheduler scheduler);
}
