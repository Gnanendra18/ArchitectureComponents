package com.incrediblepath.architecturecomponents.activities;

import com.google.gson.Gson;
import com.incrediblepath.architecturecomponents.model.Post;

public class Test {

    public static void main(String[] args) {
        Gson gson = new Gson();
        Post post = new Post(1,1,"Hello","response");
        String s = gson.toJson(post);
        Post new_post = gson.fromJson(s,Post.class);
    }
}
