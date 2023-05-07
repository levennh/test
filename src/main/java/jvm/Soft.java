package jvm;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class Soft {
    public static void main(String[] args) {
        soft();
    }

    private static void soft() {
        List<SoftReference<byte[]>> list = new ArrayList<>();

        //引用队列
        ReferenceQueue<byte[]> queue = new ReferenceQueue<>();

        for (int i = 0; i < 5; i++) {

            //当软引用关联对象被清理时,软引用本身就会加入到引用队列queue中
            SoftReference<byte[]> softReference = new SoftReference<>(new byte[1024 * 1024 * 4], queue);
            System.out.println(softReference.get());
            list.add(softReference);
            System.out.println(list.size());
        }

        //从队列中获取无用的软引用并移除
        Reference<? extends byte[]> poll = queue.poll();
        while (poll != null) {
            list.remove(poll);
            poll = queue.poll();
        }

        System.out.println("循环结束: " + list.size());
        for (SoftReference<byte[]> softReference : list) {
            System.out.println(softReference.get());
        }
    }
}
