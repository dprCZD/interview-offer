package interview.concurrent.distributed2;

/**
 * @Author: czd
 * @Description:
 * @Date: 2022/4/14 23:30
 */
public class RedisLockImpl implements DistributedLock {


    private RedisClient redis;


    private boolean tryLock(String key, Long uuid, Long expireTime) throws IllegalAccessException {
        if (expireTime == null || expireTime <= 0) {
            expireTime = DEFAULT_EXPIRE_TIME;
        }
        //> 执行加锁
        try {
            return redis.setnx(key, uuid, expireTime);
            //> 这里加锁失败抛出异常
        } catch (Exception e) {
            try {
                redis.del(key);
            } catch (Exception e1) {
                throw new IllegalAccessException("分布式锁删除锁失败！");
            }
            throw new IllegalAccessException("分布式锁加锁失败！");
        }
    }

    private void unLock(String key, Long uuid) {
        //> 这里假设用lua脚本执行
        Long lockId = (Long) redis.get(key);
        if (lockId.equals(uuid)) {
            redis.del(key);
        }
    }

    @Override
    public <T> T doBizInLock(String key, Long expireSeconds, BizCallBack<T> bizCallBack) throws IllegalAccessException {
        T result;
        Long uuid = System.currentTimeMillis();
        boolean getLock = tryLock(key, uuid, expireSeconds);
        if (!getLock) {
            throw new IllegalAccessException("未获取到分布式锁,请稍后重试");
        }
        try {
            result = bizCallBack.execute();
        } finally {
            unLock(key, uuid);
        }
        return result;
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
