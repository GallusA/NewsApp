package com.gallusawa.newsapp.data.source.local;

import android.content.ContentValues;
import android.support.annotation.NonNull;

import com.gallusawa.newsapp.data.model.Article;
import com.gallusawa.newsapp.data.model.Source;
import com.gallusawa.newsapp.data.source.local.NewsContract.SourcesEntry;
import com.gallusawa.newsapp.data.source.local.NewsContract.ArticlesEntry;

/**
 * Created by gallusawa on 12/7/17.
 */

public class NewsValues {

    public static ContentValues from(Source source) {
        ContentValues values = new ContentValues();
        values.put(SourcesEntry.SOURCE_ID, source.getId());
        values.put(SourcesEntry.SOURCE_NAME, source.getName());
        values.put(SourcesEntry.SOURCE_DESC, source.getDescription());
        values.put(SourcesEntry.SOURCE_CATEGORY, source.getCategory());
        values.put(SourcesEntry.SOURCE_URL, source.getUrl());
        values.put(SourcesEntry.SOURCE_LOGO, source.getUrlsToLogos().getMedium());
        return values;
    }

    public static ContentValues from(@NonNull String sourceId, Article article) {
        ContentValues values = new ContentValues();
        values.put(ArticlesEntry.ART_SOURCE, sourceId);
        values.put(ArticlesEntry.ART_AUTHOR, article.getAuthor());
        values.put(ArticlesEntry.ART_IMAGE, article.getImageUrl());
        values.put(ArticlesEntry.ART_TITLE, article.getTitle());
        values.put(ArticlesEntry.ART_DESC, article.getDecr());
        values.put(ArticlesEntry.ART_URL, article.getUrl());
        values.put(ArticlesEntry.ART_DATE, article.getPublishedAt());
        return values;
    }
}
