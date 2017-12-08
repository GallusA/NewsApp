package com.gallusawa.newsapp.data.source;

import java.util.List;

/**
 * Created by gallusawa on 12/7/17.
 */

public interface IDataSource {

    interface  LoadDataCallback<T> {

        void onDataLoaded(List<T> list);

        void onDataNotAvailable();
    }
}
