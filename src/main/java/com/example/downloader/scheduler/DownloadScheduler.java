package com.example.downloader.scheduler;

import com.example.downloader.cache.CacheManager;
import com.example.downloader.model.PlaylistItem;
import com.example.downloader.task.DownloadTask;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DownloadScheduler {

    private final ExecutorService executor = Executors.newFixedThreadPool(5);
    private final CacheManager cacheManager;
    private final Map<String, PlaylistItem> previous = new HashMap<>();

    public DownloadScheduler(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public synchronized void onPlaylistUpdated(List<PlaylistItem> items) {

        Map<String, PlaylistItem> current = new HashMap<>();
        for (PlaylistItem item : items) {
            current.put(item.id, item);

            if (!previous.containsKey(item.id)) {
                submit(item, "NEW");
            } else if (item.lastModified > previous.get(item.id).lastModified) {
                submit(item, "UPDATED");
            }
        }

        for (String id : previous.keySet()) {
            if (!current.containsKey(id)) {
                cacheManager.remove(id);
            }
        }

        previous.clear();
        previous.putAll(current);
    }

    private void submit(PlaylistItem item, String type) {
        System.out.println(type + " → " + item.id);
        executor.submit(new DownloadTask(item, cacheManager));
    }
}
