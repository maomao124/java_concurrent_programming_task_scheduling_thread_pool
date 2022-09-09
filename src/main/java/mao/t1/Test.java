package mao.t1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Project name(项目名称)：java并发编程_任务调度线程池
 * Package(包名): mao.t1
 * Class(类名): Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/9
 * Time(创建时间)： 17:18
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
        Timer timer = new Timer();

        TimerTask timerTask1 = new TimerTask()
        {
            @Override
            public void run()
            {
                log.debug("timerTask1开始");
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                log.debug("timerTask1结束");
            }
        };

        TimerTask timerTask2 = new TimerTask()
        {
            @Override
            public void run()
            {
                log.debug("timerTask2开始");
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                log.debug("timerTask2结束");
            }
        };

        timer.schedule(timerTask1,1000);
        timer.schedule(timerTask2,1000);
    }
}
