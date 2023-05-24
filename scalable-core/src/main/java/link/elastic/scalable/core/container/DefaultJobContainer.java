package link.elastic.scalable.core.container;

import link.elastic.scalable.core.config.ScalableConfig;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultJobContainer extends AbstractJobContainer {
    private final Set<ScalableConfig> scalableConfigSet = ConcurrentHashMap.newKeySet();

    @Override
    public boolean add(ScalableConfig scalableConfig) {
        return scalableConfigSet.add(scalableConfig);
    }

    @Override
    public boolean remove(ScalableConfig scalableConfig) {
        return scalableConfigSet.remove(scalableConfig);
    }
    @Override
    public boolean exists(ScalableConfig scalableConfig){
        return scalableConfigSet.contains(scalableConfig);
    }
}
