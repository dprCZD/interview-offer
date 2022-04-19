package interview.concurrent.distributed2;

/**
 * @Author: czd
 * @Description:
 * @Date: 2022/4/14 22:48
 */
public interface DistributedLock {


    long DEFAULT_EXPIRE_TIME = 1000L;

    <T> T doBizInLock(String key, Long expireSeconds, BizCallBack<T> bizCallBack) throws IllegalAccessException;

    interface BizCallBack<T> {
        T execute();
    }

}
