package com.gallusawa.newsapp.injection;

import android.content.Context;
import android.support.annotation.NonNull;

import com.gallusawa.newsapp.data.source.Repository;
import com.gallusawa.newsapp.data.source.local.LocalDataSource;
import com.gallusawa.newsapp.data.source.remote.ApiClient;
import com.gallusawa.newsapp.data.source.remote.ApiService;
import com.gallusawa.newsapp.data.source.remote.RemoteDataSource;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by gallusawa on 12/7/17.
 */
public class Injection {

    public static Repository provideRepository(@NonNull Context context) {
        checkNotNull(context);
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        return Repository.getInstance(RemoteDataSource.getInstance(apiService),
                LocalDataSource.getInstance(context.getContentResolver()));
    }
}
