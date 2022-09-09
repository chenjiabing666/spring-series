import org.junit.Test;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

public class ReferenceTest {
    static final int KB_1 = 1024;//1kb
    static final int MB_1 = 1024 * KB_1;//1mb
    static final int MB_5 = 5 * MB_1;//5mb
    static final int MB_50 = 50 * MB_1;//50mb

    @Test
    public void strongReference() throws InterruptedException {
        List<byte[]> list = new ArrayList<>();
        for (int i = 0; i < 300; i++) {
            list.add(new byte[MB_5]);
        }
    }

    @Test
    public void softReference() throws InterruptedException {
        //创建一个软引用，引用50mb的byte数据
        SoftReference<byte[]> sr1 = new SoftReference<>(new byte[MB_50]);
        //获取软引用中的数据
        System.out.println(sr1.get());
        //来个强引用的list
        List<byte[]> list = new ArrayList<>();
        //选好向list中添加数据，慢慢内存不足，会触发弱引用sr1中引用的50MB byte数据被回收
        for (int i = 0; i < 10; i++) {
            list.add(new byte[MB_5]);
            //获取弱引用中引用的数据
            byte[] bytes = sr1.get();
            System.out.println(list.size() + ":" + bytes);
            TimeUnit.SECONDS.sleep(1);
            if (bytes == null) {
                break;
            }
        }
    }

    @Test
    public void weakReference() throws InterruptedException {
        //创建一个弱引用，引用50mb的byte数据
        WeakReference<byte[]> sr1 = new WeakReference<>(new byte[MB_50]);
        //获取软引用中的数据
        System.out.println(sr1.get());
        System.out.println("触发gc");
        System.gc();//触发gc，会导致弱引用中的数据被回收，即sr1中引用的50mb byte被回收
        System.out.println("gc完毕");
        System.out.println(sr1.get());
    }

    @Test
    public void phantomReference() throws InterruptedException {
        //创建引用队列，当Reference对象引用的数据被回收的时候，Reference对象会被加入到这个队列中
        ReferenceQueue<byte[]> referenceQueue = new ReferenceQueue<>();
        PhantomReference<byte[]> sr1 = new PhantomReference<>(new byte[MB_50], referenceQueue);
        System.out.println(sr1);
        //获取软引用中的数据
        System.out.println(sr1.get());
        System.out.println(referenceQueue.poll());
        System.out.println("触发gc");
        System.gc();//触发gc
        System.out.println("gc完毕");
        System.out.println(sr1.get());
        System.out.println(referenceQueue.poll());
    }

    @Test
    public void sleep() throws InterruptedException {
        Thread thread = new Thread("t1") {
            @Override
            public void run() {
                try {
                    Thread.currentThread().join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public String toString() {
                return super.toString();
            }
        };
        thread.start();
        System.out.println(Integer.toHexString(thread.hashCode()));

        Thread.currentThread().setName("sleep");
        TimeUnit.SECONDS.sleep(10000);
    }

    @Test
    public void test1() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("s-" + i);
        }
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("s-" + i);
        }
        ListIterator<String> iterator = list.listIterator();
        System.out.println(iterator.next());
        System.out.println(iterator.previous());
    }
}
