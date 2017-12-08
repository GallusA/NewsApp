package com.gallusawa.newsapp.data.source;

import android.support.annotation.NonNull;

import com.gallusawa.newsapp.data.model.Article;
import com.gallusawa.newsapp.data.model.Source;

import java.util.List;

/**
 * Created by gallusawa on 12/7/17.
 */

public interface RepositoryDataSource {

    void getArticles(String source,
                     IDataSource.LoadDataCallback<Article> callback,
                     boolean isNetworkAvailable);

    void saveArticles(@NonNull List<Article> articles);

    void deleteAllArticles();

    void getSources(@NonNull IDataSource.LoadDataCallback<Source> callback,
                    boolean isNetworkAvailable);

    void saveSources(@NonNull List<Source> sources);

    void deleteAllSources();

}
