package com.flipkart.PostService;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Post {
    private int id;
    private String text;
    private List<Post> comments;
    private LocalDateTime timeStamp;
}
