package com.slicingflow.remote.zookeeper;

import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import org.apache.curator.CuratorZookeeperClient;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.ACLProvider;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.ACL;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class CuratorFactory {

    private CuratorFactory() {

    }

    public static CuratorFactory getInstance() {
        return new CuratorFactory();
    }

    public CuratorFramework createCuratorFramework(String name, ZookeeperConfiguration zookeeperConfiguration) {
        CuratorFrameworkFactory.Builder builder = CuratorFrameworkFactory.builder()
                .connectString(zookeeperConfiguration.getServerLists())
                .retryPolicy(new ExponentialBackoffRetry(zookeeperConfiguration.getBaseSleepTimeMilliseconds(),
                        zookeeperConfiguration.getMaxRetries(), zookeeperConfiguration.getMaxSleepTimeMilliseconds()))
                .namespace(zookeeperConfiguration.getNamespace());
        if (0 != zookeeperConfiguration.getSessionTimeoutMilliseconds()) {
            builder.sessionTimeoutMs(zookeeperConfiguration.getSessionTimeoutMilliseconds());
        }
        if (0 != zookeeperConfiguration.getConnectionTimeoutMilliseconds()) {
            builder.connectionTimeoutMs(zookeeperConfiguration.getConnectionTimeoutMilliseconds());
        }
        if (!Strings.isNullOrEmpty(zookeeperConfiguration.getDigest())) {
            builder.authorization("digest", zookeeperConfiguration.getDigest().getBytes(Charsets.UTF_8))
                    .aclProvider(new ACLProvider() {

                        @Override
                        public List<ACL> getDefaultAcl() {
                            return ZooDefs.Ids.CREATOR_ALL_ACL;
                        }

                        @Override
                        public List<ACL> getAclForPath(final String path) {
                            return ZooDefs.Ids.CREATOR_ALL_ACL;
                        }
                    });
        }
        CuratorFramework curatorFramework = builder.build();

        return curatorFramework;
    }



}
