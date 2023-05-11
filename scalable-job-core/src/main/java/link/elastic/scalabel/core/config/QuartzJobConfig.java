package link.elastic.scalabel.core.config;

public class QuartzJobConfig extends AbstractJobConfig{

        private String cron;

        public String getCron() {
            return cron;
        }

        public void setCron(String cron) {
            this.cron = cron;
        }

    @Override
    public String toString() {
        return "QuartzJobConfig{" +
                "cron='" + cron + '\'' +
                '}';
    }
}
