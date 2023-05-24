package link.elastic.scalable.core.container;

import link.elastic.scalable.core.config.ScalableConfig;

public interface JobContainer {

    boolean add(ScalableConfig scalableConfig);

    boolean remove(ScalableConfig scalableConfig);


}
