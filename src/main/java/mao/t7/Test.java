package mao.t7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * Project name(项目名称)：java并发编程_任务调度线程池
 * Package(包名): mao.t7
 * Class(类名): Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/9
 * Time(创建时间)： 20:10
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test
{
    /**
     * 日志
     */
    private static final Logger log = LoggerFactory.getLogger(mao.t5.Test.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
        log.debug("开始运行");
        ExecutorService threadPool = Executors.newFixedThreadPool(1);

        for (int i = 0; i < 2; i++)
        {
            int finalI = i;
            Future<?> future = threadPool.submit(new Runnable()
            {
                @Override
                @SuppressWarnings("all")
                public void run()
                {
                    log.debug(finalI + "开始");
                    int j = 1 / 0;
                    log.debug(finalI + "结束");
                }
            });
            future.get();
        }
    }
}
