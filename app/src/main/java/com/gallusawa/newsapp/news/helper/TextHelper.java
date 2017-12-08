package com.gallusawa.newsapp.news.helper;

/**
 * Created by gallusawa on 12/8/17.
 */

public class TextHelper {

    private static TextHelper helper = null;

    public static TextHelper getInstance() {
        if (helper == null) {
            helper = new TextHelper();
        }
        return helper;
    }

    public String getText(int progress) {
        if (progress >= 0 && progress < 50) {
            return "low";
        } else {
            return "high";
        }
    }
}