package com.slicingflow.remote.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.KeeperException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author songxiaosheng
 */
public class CuratorPool implements CuratorManager {
    private final Logger logger = LoggerFactory.getLogger(CuratorPool.class);
    private final ConcurrentHashMap<String, CuratorFramework> curatorClientCache;
    private final ZookeeperConfigurationCache zookeeperConfigurationCache;
    private final Lock lock = new ReentrantLock();

    {
        curatorClientCache = new ConcurrentHashMap<>();
        zookeeperConfigurationCache = new ZookeeperConfigurationCache();
    }

    private CuratorPool() {

    }

    @Override
    public void init() {
        zookeeperConfigurationCache.init();
    }

    @Override
    public CuratorFramework getCurator(String name) {
        CuratorFramework curatorFramework = curatorClientCache.get(name);
        if (curatorFramework != null) {
            return curatorFramework;
        }
        //only support init once
        lock.lock();
        try {
            curatorFramework = curatorClientCache.get(name);
            if (curatorFramework != null) {
                return curatorFramework;
            }
            CuratorFactory instance = CuratorFactory.getInstance();
            ZookeeperConfiguration zookeeperConfiguration = new ZookeeperConfiguration();
            curatorFramework = instance.createCuratorFramework(name, zookeeperConfiguration);
            curatorFramework.start();
            if (!curatorFramework.blockUntilConnected(zookeeperConfiguration.getMaxSleepTimeMilliseconds()
                    * zookeeperConfiguration.getMaxRetries(), TimeUnit.MILLISECONDS)) {
                curatorFramework.close();
                throw new KeeperException.OperationTimeoutException();
            }
            curatorClientCache.put(name, curatorFramework);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("init CuratorFramework error message is:{}", e);
        } finally {
            lock.unlock();
        }

        return curatorFramework;
    }



    @Override
    public void stop(String name) {
        CuratorFramework curatorFramework = curatorClientCache.get(name);
        if(curatorFramework!=null){
            curatorFramework.close();
        }
    }

    @Override
    public void stop() {
        curatorClientCache.entrySet().forEach(curatorFramework->{
            curatorFramework.getValue().close();
        });
        curatorClientCache.clear();
    }

}
