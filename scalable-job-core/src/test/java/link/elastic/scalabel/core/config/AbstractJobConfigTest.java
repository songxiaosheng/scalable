package link.elastic.scalabel.core.config;

class AbstractJobConfigTest {

    @org.junit.jupiter.api.Test
    void getJobName() {
        new QuartzJobConfig().getJobName();
    }

    @org.junit.jupiter.api.Test
    void setJobName() {
        new QuartzJobConfig().setJobName("test");
    }

    @org.junit.jupiter.api.Test
    void getJobHandler() {
        new QuartzJobConfig().getJobHandler();
    }

    @org.junit.jupiter.api.Test
    void setJobHandler() {
        new QuartzJobConfig().setJobHandler(null);
    }
}