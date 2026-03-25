package com.example.downloader.downloader;

import com.example.downloader.model.PlaylistItem;

public interface Downloader {
    void download(PlaylistItem item);
}
