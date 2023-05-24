package link.elastic.scalable.core.container;

import link.elastic.scalable.core.config.ScalableConfig;

public abstract class AbstractJobContainer implements JobContainer{

    public abstract boolean exists(ScalableConfig scalableConfig);
}
