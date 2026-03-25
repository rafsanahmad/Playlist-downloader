package com.example.downloader.watcher;

import com.example.downloader.model.PlaylistItem;
import com.example.downloader.scheduler.DownloadScheduler;

import java.util.*;

public class PlaylistWatcher implements Runnable {

    private final DownloadScheduler scheduler;

    public PlaylistWatcher(DownloadScheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public void run() {
        int version = 0;

        while (true) {
            List<PlaylistItem> items = mockPlaylist(version++);
            scheduler.onPlaylistUpdated(items);

            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private List<PlaylistItem> mockPlaylist(int version) {
        List<PlaylistItem> list = new ArrayList<>();

        list.add(new PlaylistItem("1",
                "https://via.placeholder.com/150",
                "IMAGE",
                System.currentTimeMillis()));

        if (version > 1) {
            list.add(new PlaylistItem("2",
                    "https://via.placeholder.com/200",
                    "IMAGE",
                    System.currentTimeMillis()));
        }

        if (version > 2) {
            list.remove(0);
        }

        return list;
    }
}
