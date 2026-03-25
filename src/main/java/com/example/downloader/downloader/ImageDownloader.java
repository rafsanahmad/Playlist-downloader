package com.example.downloader.downloader;

import com.example.downloader.model.PlaylistItem;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageDownloader implements Downloader {

    @Override
    public void download(PlaylistItem item) {
        try (InputStream in = new URL(item.url).openStream()) {
            Path path = Path.of("downloads/" + item.id + ".img");
            Files.createDirectories(path.getParent());
            Files.copy(in, path);
            System.out.println("Downloaded: " + item.url);
        } catch (Exception e) {
            System.out.println("Download failed: " + e.getMessage());
        }
    }
}
