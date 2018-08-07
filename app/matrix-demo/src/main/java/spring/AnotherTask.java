package spring;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class AnotherTask {

    // 时间解析器
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    // 执行任务
    public void execute() {
        log.info("Task2" + simpleDateFormat.format(new Date()));
    }
}
