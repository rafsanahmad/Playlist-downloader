package com.example.downloader.manager;

import com.example.downloader.scheduler.DownloadScheduler;
import com.example.downloader.watcher.PlaylistWatcher;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PlaylistManager {

    private final ExecutorService watcherPool = Executors.newCachedThreadPool();

    public void register(DownloadScheduler scheduler) {
        watcherPool.submit(new PlaylistWatcher(scheduler));
    }
}
