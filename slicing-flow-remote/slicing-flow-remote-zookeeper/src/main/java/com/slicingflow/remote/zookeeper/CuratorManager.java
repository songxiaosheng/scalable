package com.slicingflow.remote.zookeeper;

import org.apache.curator.framework.CuratorFramework;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author songxiaosheng
 */
public interface CuratorManager {

     void init();
     CuratorFramework getCurator(String name);

     void stop(String name);
     void stop();



}
