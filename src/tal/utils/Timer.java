package tal.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Timer {

    private long startTimeMilis;
    private long endTimeMilis;

    Double time;

    public Timer() {

    }

    public void start() {
        this.startTimeMilis = System.currentTimeMillis();
    }

    public void stop() {
        this.endTimeMilis = System.currentTimeMillis();
    }

    public Long getStartTimeMilis() {
        return startTimeMilis;
    }

    public Long getEndTimeMilis() {
        return endTimeMilis;
    }

    public Long getDurationMilis() {
        return endTimeMilis - startTimeMilis;
    }

    public Double getDurationSecs() {
        return (BigDecimal.valueOf((endTimeMilis - startTimeMilis) / 1000.0d) .setScale(3, RoundingMode.HALF_UP)).doubleValue();
    }
}
