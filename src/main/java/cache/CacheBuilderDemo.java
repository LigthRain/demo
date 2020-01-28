package cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CacheBuilderDemo {

    private static final ListeningExecutorService backgroundRefreshPools =
            MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(20));

    public static void main(String[] args) {

        LoadingCache<String, Object> caches = CacheBuilder.newBuilder()
                .maximumSize(100)
                .refreshAfterWrite(10, TimeUnit.MILLISECONDS)
                .build(new CacheLoader<String, Object>() {
                    @Override
                    public Object load(String key) throws Exception {
                        return generateValueByKey(key);
                    }

                    @Override
                    public ListenableFuture<Object> reload(final String key,
                                                           Object oldValue) throws Exception {
                        return backgroundRefreshPools.submit(new Callable<Object>() {

                            @Override
                            public Object call() throws Exception {
                                return generateValueByKey(key);
                            }
                        });
                    }
                });
        caches.put("1", "1");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(caches.getIfPresent("1"));
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println(caches.getIfPresent("1"));
        backgroundRefreshPools.shutdown();
    }

    private static Object generateValueByKey(String key) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行");
        return "load后的结果";
    }

}
