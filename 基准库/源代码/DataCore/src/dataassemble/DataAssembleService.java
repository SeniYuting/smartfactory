package dataassemble;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * 数据组装线程调度类
 * @author Victor_Zhou
 *
 */
public class DataAssembleService {
    private ScheduledExecutorService scheduledExecutorService;
    private Map<String, ScheduledFuture> DataAssembles;

    public DataAssembleService(int threadNum) {
        scheduledExecutorService = Executors.newScheduledThreadPool(threadNum);
        DataAssembles = new HashMap<>();
    }

    /**
     * 将组数据装线程加入线程池
     * @param task
     */
    public void appendTask(DataAssemble task) {
        if (DataAssembles.containsKey(task.getResultDataId())) {
            DataAssembles.get(task.getResultDataId()).cancel(false);
        }

        ScheduledFuture scheduledFuture =
                scheduledExecutorService.scheduleAtFixedRate(task::run, 0,
                        task.getDataAssembleIntervalInSeconds(), TimeUnit.SECONDS);
        DataAssembles.put(task.getResultDataId(), scheduledFuture);
    }
}
