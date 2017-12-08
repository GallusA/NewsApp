package com.gallusawa.newsapp.sources;

import android.support.annotation.NonNull;

import com.gallusawa.newsapp.BasePresenter;
import com.gallusawa.newsapp.BaseView;
import com.gallusawa.newsapp.data.model.Source;

import java.util.List;

/**
 * Created by gallusawa on 12/7/17.
 */
public interface SourcesContract  {

    interface View extends BaseView {

        void showSources(@NonNull List<Source> sources);

        void setRefreshing(boolean refreshing);

        boolean isNetworkAvailable();

        boolean isActive();

        void showLoadingSourcesError();

        void showNoSourcesData();
    }

    interface Presenter extends BasePresenter {

      void loadSources();
    }
}
