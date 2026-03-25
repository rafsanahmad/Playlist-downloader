package com.example.downloader.downloader;

public class DownloaderFactory {
    public static Downloader getDownloader(String type) {
        switch (type) {
            case "IMAGE": return new ImageDownloader();
            case "VIDEO": return new VideoDownloader();
            case "HTML": return new HtmlDownloader();
            default: throw new IllegalArgumentException("Unknown type");
        }
    }
}
