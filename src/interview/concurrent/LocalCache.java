package interview.concurrent;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: czd
 * @Description: 通过LinkedHashMap实现的本地缓存。
 * @Date: 2022/4/16 22:49
 */
public class LocalCache<KeyType extends Serializable, ValueType> extends LinkedHashMap<KeyType, ValueType> {

    private final static int MAX_LOCAL_CACHE_CAPACITY = 4096;

    private final static int DEFAULT_LOCAL_CACHE_CAPACITY = 512;

    private int capacity = DEFAULT_LOCAL_CACHE_CAPACITY;

    public LocalCache() {
        super(DEFAULT_LOCAL_CACHE_CAPACITY, 0.75F, true);
    }

    public LocalCache(int capacity) {
        super(capacity > MAX_LOCAL_CACHE_CAPACITY ? MAX_LOCAL_CACHE_CAPACITY : capacity, 0.75F, true);
    }

    public ValueType get(KeyType key) {
        return super.get(key);

    }

    public ValueType put(KeyType key, ValueType value) {
        return super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<KeyType, ValueType> eldest) {
        return size() > capacity;
    }
}
