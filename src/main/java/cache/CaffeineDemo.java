package cache;

import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.*;

public class CaffeineDemo {
    private static final ListeningExecutorService backgroundRefreshPools =
            MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(20));

    static LoadingCache<String,String> cache = Caffeine.newBuilder()

            .refreshAfterWrite(100,TimeUnit.MILLISECONDS)

//            .executor(new ThreadPoolExecutor(1,
//                    1,
//                    0,
//                    TimeUnit.MILLISECONDS,
//                    new ArrayBlockingQueue<>(2),
//                    new ThreadPoolExecutor.DiscardPolicy()))


            .build(CaffeineDemo::generateValueByKey);


    public static void main(String[] args) {

        cache.put("1", "1");
        cache.put("3", "3");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println(Thread.currentThread() + cache.getIfPresent("1"));
        System.out.println(Thread.currentThread() + cache.getIfPresent("3"));
        ExecutorService exe = Executors.newFixedThreadPool(3);
        exe.submit(() -> {
            System.out.println("线程池" +Thread.currentThread() + cache.getIfPresent("3"));
        });
        exe.submit(() -> {
            System.out.println("线程池" +Thread.currentThread() + cache.getIfPresent("3"));
        });
        exe.submit(() -> {
            System.out.println("线程池" +Thread.currentThread() + cache.getIfPresent("3"));
        });
//        System.out.println(Thread.currentThread() + cache.getIfPresent("1"));
//        try {
//            Thread.sleep(400);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(Thread.currentThread() + cache.getIfPresent("1"));
//        System.out.println(Thread.currentThread() + cache.getIfPresent("2"));
//        System.out.println(Thread.currentThread() + cache.getIfPresent("3"));
//        System.out.println(Thread.currentThread() + cache.getIfPresent("3"));
//        cache.invalidate("1");
//        System.out.println(cache.getIfPresent("1"));
        try {
            Thread.sleep(100000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private static String generateValueByKey(String key) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(key + Thread.currentThread() + "执行");
        // 整体缓存更新
        // invalidate无效值
        cache.put("3", "new 3");
//        cache.invalidate("3");
//        return cache.getIfPresent("3");
        return key + "load后的值";
    }

}
