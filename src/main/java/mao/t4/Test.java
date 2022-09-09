package mao.t4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Project name(项目名称)：java并发编程_任务调度线程池
 * Package(包名): mao.t4
 * Class(类名): Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/9
 * Time(创建时间)： 17:41
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
            //提交一个周期性操作，该操作首先在给定的初始延迟之后启用，随后在一个执行的终止和下一个执行的开始之间具有给定的延迟。
            //任务执行的顺序无限期地继续，直到发生以下异常完成之一：
            //该任务通过返回的未来显式取消。
            //执行器终止，也导致任务取消。
            //任务的执行会引发异常。在这种情况下，在返回的 future 上调用get将抛出ExecutionException ，并将异常作为其原因。
            //随后的执行被禁止。在返回的未来上对isDone()的后续调用将返回true
            //参数：
            //command - 要执行的任务
            //initialDelay – 延迟首次执行的时间
            //延迟 - 一个执行的终止和下一个执行的开始之间的延迟
            //unit – initialDelay 和 delay 参数的时间单位
            threadPool.scheduleWithFixedDelay(new Runnable()
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
