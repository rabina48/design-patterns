package com.sabu.proxydesignpattern.service;

import com.sabu.proxydesignpattern.dto.Video;

import java.util.HashMap;

public interface ThirdPartyYouTubeLib {

    HashMap<String, Video> popularVideos();

    Video getVideo(String videoId);
}
