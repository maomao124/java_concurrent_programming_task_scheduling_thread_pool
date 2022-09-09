package mao.t2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Project name(项目名称)：java并发编程_任务调度线程池
 * Package(包名): mao.t2
 * Class(类名): Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/9
 * Time(创建时间)： 17:23
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test
{
    /**
     * 日志
     */
    private static final Logger log = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args)
    {
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(2);

        for (int i = 0; i < 2; i++)
        {
            int finalI = i;
            threadPool.schedule(new Runnable()
            {
                @Override
                public void run()
                {
                    log.debug(finalI + "开始");
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    log.debug(finalI + "结束");
                }
            }, 1, TimeUnit.SECONDS);
        }

    }
}
