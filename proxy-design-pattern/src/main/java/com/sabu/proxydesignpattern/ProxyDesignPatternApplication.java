package com.sabu.proxydesignpattern;

import com.sabu.proxydesignpattern.downloader.YouTubeDownloader;
import com.sabu.proxydesignpattern.proxy.YouTubeCacheProxy;
import com.sabu.proxydesignpattern.service.ThirdPartyYouTubeClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProxyDesignPatternApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProxyDesignPatternApplication.class, args);
        YouTubeDownloader naiveDownloader =  new YouTubeDownloader(new ThirdPartyYouTubeClass());
        YouTubeDownloader smartDownloader =  new YouTubeDownloader(new YouTubeCacheProxy());

        long naive = test(naiveDownloader);
        long smart= test(smartDownloader);
        System.out.print("Time saved by caching proxy: " + (naive - smart) + "ms");
    }

    public static long test(YouTubeDownloader downloader){
        long startTime = System.currentTimeMillis();

        // User behavior in our app:
        downloader.renderPopularVideos();
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderPopularVideos();
        downloader.renderVideoPage("dancesvideoo");
        // Users might visit the same page quite often.
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderVideoPage("someothervid");

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print("Time elapsed: " + estimatedTime + "ms\n");
        return estimatedTime;
    }

}
