package com.slicingflow.remote.zookeeper;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author songxiaosheng
 */
public class ZookeeperConfigurationCache {
    private Map<String, ZookeeperConfiguration> configurationMap = new ConcurrentHashMap<>();

    private final String ZOOKEEPER_PROPERTIES_FILE;

    private final String ZOOKEEPER_PROPERTIES_FILE_KEY = "zookeeper.properties.file";

    private final String DEFAULT_ZOOKEEPER_PROPERTIES_FILE = "zookeeper.properties";

    {

        ZOOKEEPER_PROPERTIES_FILE = System.getProperty(ZOOKEEPER_PROPERTIES_FILE_KEY, DEFAULT_ZOOKEEPER_PROPERTIES_FILE);
    }

    //load configuration from jvm args,if use zookeeper config need load on start up
    public void init() {

    }

}
