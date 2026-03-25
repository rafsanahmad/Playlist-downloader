package com.example.downloader.cache;

import com.example.downloader.model.PlaylistItem;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

public class CacheManager {

    private final int capacity;

    private final LinkedHashMap<String, PlaylistItem> cache =
            new LinkedHashMap<>(16, 0.75f, true) {
                protected boolean removeEldestEntry(Map.Entry<String, PlaylistItem> eldest) {
                    if (size() > capacity) {
                        deleteFile(eldest.getValue());
                        return true;
                    }
                    return false;
                }
            };

    public CacheManager(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void put(PlaylistItem item) {
        cache.put(item.id, item);
    }

    public synchronized void remove(String id) {
        PlaylistItem item = cache.remove(id);
        if (item != null) deleteFile(item);
    }

    private void deleteFile(PlaylistItem item) {
        File file = new File("downloads/" + item.id + ".img");
        if (file.exists()) {
            file.delete();
            System.out.println("Deleted: " + item.id);
        }
    }
}
