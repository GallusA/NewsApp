package com.gallusawa.newsapp.news;

import android.support.annotation.NonNull;

import com.gallusawa.newsapp.BasePresenter;
import com.gallusawa.newsapp.BaseView;
import com.gallusawa.newsapp.data.model.Article;

import java.util.List;

/**
 * Created by gallusawa on 12/7/17.
 */
public interface NewsContract {

    interface View extends BaseView {

        void showArticles(@NonNull List<Article> sources);

        void setRefreshing(boolean refreshing);

        boolean isNetworkAvailable();

        boolean isActive();

        void showLoadingSourcesError();

        void showNoSourcesData();
    }

    interface Presenter extends BasePresenter {

        void loadArticles(String sourceId);
    }
}
