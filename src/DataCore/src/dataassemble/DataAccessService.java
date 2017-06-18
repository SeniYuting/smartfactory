package dataassemble;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * 数据获取线程调度类
 * @author Victor_Zhou
 *
 */
public class DataAccessService {
    class ScheduledTask {
        public ScheduledFuture scheduledFuture;
        public int periodInMinutes;
    }
    private Map<String, ScheduledTask> DataAccesss;
    private ScheduledExecutorService scheduledExecutorService;

    public DataAccessService(int threadNum) {
        DataAccesss = new HashMap<>();
        scheduledExecutorService = Executors.newScheduledThreadPool(threadNum);
    }

    /**
     * 将数据获取线程加入线程池
     * @param tasks
     */
    public void appendTask(List<DataAccess> tasks) {
        for (DataAccess task : tasks) {
            if (DataAccesss.containsKey(task.getDataId())) {
                ScheduledTask scheduledTask =
                        DataAccesss.get(task.getDataId());

                if (scheduledTask.periodInMinutes >
                        task.getDataAccessIntervalInSeconds()) {
                    scheduledTask.scheduledFuture.cancel(false);
                }
            }

            ScheduledTask scheduledTask = new ScheduledTask();
            scheduledTask.scheduledFuture =
                    scheduledExecutorService.scheduleAtFixedRate(task::run, 0,
                            task.getDataAccessIntervalInSeconds(), TimeUnit.SECONDS);
            scheduledTask.periodInMinutes = task.getDataAccessIntervalInSeconds();

            DataAccesss.put(task.getDataId(), scheduledTask);
        }
    }
}