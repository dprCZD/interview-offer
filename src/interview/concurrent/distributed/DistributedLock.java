package interview.concurrent.distributed;

/**
 * @Author: czd
 * @Description:
 * @Date: 2022/4/14 22:48
 */
public abstract class DistributedLock {


    public final static long DEFAULT_EXPIRE_TIME = 1000L;

    protected String lockKey = "lock";

    public DistributedLock(String key) {
        this.lockKey = key;
    }

    public abstract boolean tryLock(Long expireTime) throws IllegalAccessException;

    public abstract void unLock();

}
