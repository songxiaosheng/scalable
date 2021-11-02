package com.slicingflow.remote.zookeeper;

import org.apache.curator.CuratorZookeeperClient;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;

import java.util.concurrent.ConcurrentHashMap;

public class CuratorFactory {
    private final ConcurrentHashMap<String, CuratorFramework> curatorClientCache = new ConcurrentHashMap<>();

    private CuratorFactory() {

    }

    public CuratorFramework createCuratorFramework(String name) {
        CuratorFrameworkFactory.Builder builder = CuratorFrameworkFactory.builder();
        CuratorFramework curatorFramework = builder.build();
        curatorClientCache.put(name, curatorFramework);
        return curatorFramework;
    }
    public void start(String name){
        CuratorFramework curatorFramework = curatorClientCache.get(name);
        curatorFramework.start();
    }
    public void stop(){

    }
    //singleton


}
