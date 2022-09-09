package mao.t3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Project name(项目名称)：java并发编程_任务调度线程池
 * Package(包名): mao.t3
 * Class(类名): Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/9
 * Time(创建时间)： 17:32
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
        log.debug("开始运行");
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(2);

        for (int i = 0; i < 2; i++)
        {
            int finalI = i;
            //提交在给定初始延迟后首先启用的周期性操作，随后在给定周期内启用；
            //也就是说，执行将在initialDelay之后开始，
            //然后是initialDelay + period ，然后是initialDelay + 2 * period ，依此类推。
            //任务执行的顺序无限期地继续，直到发生以下异常完成之一：
            //该任务通过返回的未来显式取消。
            //执行器终止，也导致任务取消。
            //任务的执行会引发异常。在这种情况下，在返回的 future 上调用get将抛出ExecutionException ，并将异常作为其原因。
            //随后的执行被禁止。在返回的未来上对isDone()的后续调用将返回true 。
            //如果此任务的任何执行时间超过其周期，则后续执行可能会延迟开始，但不会同时执行
            //参数：
            //command - 要执行的任务
            //initialDelay – 延迟首次执行的时间
            //period – 连续执行之间的时间段
            //unit – initialDelay 和 period 参数的时间单位
            threadPool.scheduleAtFixedRate(new Runnable()
            {
                @Override
                public void run()
                {
                    log.debug(finalI + "开始");
                    try
                    {
                        Thread.sleep(3000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    log.debug(finalI + "结束");
                }
            }, 1, 2, TimeUnit.SECONDS);
        }
    }
}
