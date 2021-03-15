package com.sabu.proxydesignpattern.downloader;

import com.sabu.proxydesignpattern.dto.Video;
import com.sabu.proxydesignpattern.service.ThirdPartyYouTubeLib;

import java.util.HashMap;

public class YouTubeDownloader {

    private final ThirdPartyYouTubeLib thirdPartyYouTubeLib;

    public YouTubeDownloader(ThirdPartyYouTubeLib api) {
        this.thirdPartyYouTubeLib = api;
    }

    public void renderVideoPage(String videoId) {
        Video video = thirdPartyYouTubeLib.getVideo(videoId);
        System.out.println("\n-------------------------------");
        System.out.println("Video page (imagine fancy HTML)");
        System.out.println("ID: " + video.id);
        System.out.println("Title: " + video.title);
        System.out.println("Video: " + video.data);
        System.out.println("-------------------------------\n");
    }

    public void renderPopularVideos() {
        HashMap<String, Video> list = thirdPartyYouTubeLib.popularVideos();
        System.out.println("\n-------------------------------");
        System.out.println("Most popular videos on YouTube (imagine fancy HTML)");
        for (Video video : list.values()) {
            System.out.println("ID: " + video.id + " / Title: " + video.title);
        }
        System.out.println("-------------------------------\n");
    }
}
