package com.example.downloader;

import com.example.downloader.cache.CacheManager;
import com.example.downloader.manager.PlaylistManager;
import com.example.downloader.scheduler.DownloadScheduler;

public class Main {

    public static void main(String[] args) {

        CacheManager cacheManager = new CacheManager(3);
        DownloadScheduler scheduler = new DownloadScheduler(cacheManager);

        PlaylistManager manager = new PlaylistManager();
        manager.register(scheduler);

        System.out.println("System started...");
    }
}
