# Playlist Downloader System (Java)

A scalable system that monitors playlist URLs, detects changes, and downloads content (images, videos, HTML, etc.) efficiently with caching and concurrency.

---

## Features
- Monitor multiple playlists
- Detect changes (Add / Update / Delete)
- Download content asynchronously
- Disk-based caching with LRU eviction

---

## Architecture

PlaylistManager → PlaylistWatcher → DownloadScheduler → ThreadPool → DownloadTask → CacheManager

---

## Flow
1. Register playlist
2. Watcher polls playlist
3. Detect changes
4. Scheduler processes diff
5. Download tasks executed
6. Files cached on disk

---

## Run

Compile:
javac -d out $(find . -name "*.java")

Run:
java -cp out com.example.downloader.Main
