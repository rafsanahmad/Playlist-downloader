package com.example.downloader.task;

import com.example.downloader.cache.CacheManager;
import com.example.downloader.downloader.Downloader;
import com.example.downloader.downloader.DownloaderFactory;
import com.example.downloader.model.PlaylistItem;

public class DownloadTask implements Runnable {

    private final PlaylistItem item;
    private final CacheManager cacheManager;

    public DownloadTask(PlaylistItem item, CacheManager cacheManager) {
        this.item = item;
        this.cacheManager = cacheManager;
    }

    @Override
    public void run() {
        Downloader downloader = DownloaderFactory.getDownloader(item.type);
        downloader.download(item);
        cacheManager.put(item);
    }
}
