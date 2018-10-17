import lombok.extern.slf4j.Slf4j;

/**
 * @author 张玉尧（matrix.zhang@ximalaya.com）
 * @version $Id: LombokLogTest.java, v 0.1 2018年10月15日 下午2:20:51 张玉尧（matrix.zhang@ximalaya.com） Exp $
 */
@Slf4j
public class LombokLogTest {
    public static void main(String[] args) {
        log.info("测试：{},{},{}", 1, 2, 3);
        try {
            log.info("divide：{}", 1 / 0);
        } catch (Exception e) {
            log.error("测试：{},{},{}", 4, 5, 6, e);
        }
        log.info("end!");
    }
}
