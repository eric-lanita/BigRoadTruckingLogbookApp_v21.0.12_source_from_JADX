package com.google.common.collect;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Map.Entry;

final class C3604v {
    static int m18821a(ObjectInputStream objectInputStream) {
        return objectInputStream.readInt();
    }

    static <K, V> void m18823a(C3510p<K, V> c3510p, ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(c3510p.mo2615b().size());
        for (Entry entry : c3510p.mo2615b().entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(((Collection) entry.getValue()).size());
            for (Object writeObject : (Collection) entry.getValue()) {
                objectOutputStream.writeObject(writeObject);
            }
        }
    }

    static <K, V> void m18822a(C3510p<K, V> c3510p, ObjectInputStream objectInputStream, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            Collection b = c3510p.mo2621b(objectInputStream.readObject());
            int readInt = objectInputStream.readInt();
            for (int i3 = 0; i3 < readInt; i3++) {
                b.add(objectInputStream.readObject());
            }
        }
    }
}
