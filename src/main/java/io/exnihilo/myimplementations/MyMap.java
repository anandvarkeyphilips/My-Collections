package io.exnihilo.myimplementations;

import java.util.Objects;

public class MyMap<K, V> {
    private Entry<K, V>[] buckets;
    private static final int INITIAL_CAPACITY = 1 << 4; // 16

    private int size = 0;

    public MyMap() {
        this(INITIAL_CAPACITY);
    }

    public MyMap(int capacity) {
        this.buckets = new Entry[capacity];
    }

    public void put(K key, V value) {
        Entry<K, V> entry = new Entry<>(key, value, null);

        int bucket = getHash(key) % getBucketSize();

        Entry<K, V> existing = buckets[bucket];
        if (existing == null) {
            buckets[bucket] = entry;
            size++;
        } else {
            // compare the keys see if key already exists
            while (existing.next != null) {
                if (existing.key.equals(key)) {
                    existing.value = value;
                    return;
                }
                existing = existing.next;
            }

            if (existing.key.equals(key)) {
                existing.value = value;
            } else {
                existing.next = entry;
                size++;
            }
        }
    }

    public V get(K key) {
        Entry<K, V> bucket = buckets[getHash(key) % getBucketSize()];

        while (bucket != null) {
            if (key == bucket.key) {
                return bucket.value;
            }
            bucket = bucket.next;
        }
        return null;
    }

    public int size() {
        return size;
    }

    private int getBucketSize() {
        return buckets.length;
    }

    private int getHash(K key) {
        return key == null ? 0 : Math.abs(key.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Entry entry : buckets) {
            sb.append("[");
            while (entry != null) {
                sb.append(entry);
                if (entry.next != null) {
                    sb.append(", ");
                }
                entry = entry.next;
            }
            sb.append("]");
        }
        return "{" + sb.toString() + "}";
    }

    static class Entry<K, V> {
        private final K key;
        private V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Entry<K, V> getNext() {
            return next;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Entry) {
                Entry other = (Entry) obj;
                return Objects.equals(this.key, other.getKey()) && Objects.equals(this.getValue(), other.getValue());
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.key, this.value);
        }

        @Override
        public String toString() {
            return "{" + key + ", " + value + "}";
        }
    }
}