package interview.concurrent.distributed;


/**
 * @Author: czd
 * @Description:
 * @Date: 2022/4/14 22:50
 */
public class RedisLockImpl extends DistributedLock {

    private RedisClient redis;

    private ThreadLocal<Long> uuid = new ThreadLocal<>();

    public RedisLockImpl(String key,RedisClient redis) {
        super(key);
        this.redis=redis;
    }


    @Override
    public boolean tryLock(Long expireTime) throws IllegalAccessException {
        if (expireTime == null || expireTime <= 0) {
            expireTime = DEFAULT_EXPIRE_TIME;
        }
        //> 执行加锁
        try {
            uuid.set(System.currentTimeMillis());
            return redis.setnx(lockKey, uuid.get(), expireTime);
        } catch (Exception e) {
            //> 这里加锁失败抛出异常
            try {
                redis.del(lockKey);
            } catch (Exception e1) {
                throw new IllegalAccessException("分布式锁删除锁失败！");
            }
            throw new IllegalAccessException("分布式锁加锁失败！");
        }
    }

    @Override
    public void unLock() {
        //> 这里假设用lua脚本执行
        Long lockId = (Long) redis.get(lockKey);
        if (lockId.equals(uuid.get())) {
            redis.del(lockKey);
            uuid.remove();
        }
    }

    public static class RedisClient {
        public boolean setnx(String key, Object value, Long expireTime) {
            return true;
        }

        public Object get(String key) {
            return null;
        }

        public void del(String key) {
        }
    }
}
