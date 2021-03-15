package com.sabu.proxydesignpattern.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Video {

    public String id;

    public String title;

    public String data;

    public Video(String id, String title) {
        this.id = id;
        this.title = title;
        this.data = "Random video.";
    }
}
