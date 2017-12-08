package com.gallusawa.newsapp.data.source.remote;

import android.support.annotation.NonNull;

import com.gallusawa.newsapp.data.model.Article;
import com.gallusawa.newsapp.data.model.Source;
import com.gallusawa.newsapp.data.source.IDataSource;

/**
 * Created by gallusawa on 12/7/17.
 */

public interface IRemoteDataSource extends IDataSource {

    void getSources(@NonNull  LoadDataCallback<Source> callback);

    void getArticles(String source, @NonNull LoadDataCallback<Article> callback);
}
