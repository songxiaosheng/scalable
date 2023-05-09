package link.elastic.scalabel.core.config;

import static org.junit.jupiter.api.Assertions.*;

class AbstractJobConfigTest {

    @org.junit.jupiter.api.Test
    void getJobName() {
        new SimpleJobConfig().getJobName();
    }

    @org.junit.jupiter.api.Test
    void setJobName() {
        new SimpleJobConfig().setJobName("test");
    }

    @org.junit.jupiter.api.Test
    void getJobHandler() {
        new SimpleJobConfig().getJobHandler();
    }

    @org.junit.jupiter.api.Test
    void setJobHandler() {
        new SimpleJobConfig().setJobHandler(null);
    }
}