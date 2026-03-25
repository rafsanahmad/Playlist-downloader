package com.example.downloader.model;

import java.util.Objects;

public class PlaylistItem {
    public String id;
    public String url;
    public String type;
    public long lastModified;

    public PlaylistItem(String id, String url, String type, long lastModified) {
        this.id = id;
        this.url = url;
        this.type = type;
        this.lastModified = lastModified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlaylistItem)) return false;
        PlaylistItem that = (PlaylistItem) o;
        return Objects.equals(id, that.id) &&
               lastModified == that.lastModified;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastModified);
    }
}
