package com.gallusawa.newsapp.sources;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.gallusawa.newsapp.R;
import com.gallusawa.newsapp.data.model.Source;
import com.gallusawa.newsapp.injection.Injection;
import com.gallusawa.newsapp.news.NewsActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gallusawa on 12/7/17.
 */
public class SourcesActivity extends AppCompatActivity implements SourcesContract.View {

    private SourcesContract.Presenter presenter;
    private SourcesRecyclerViewAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        initToolbar();
        initRecycler();
        initSwipeToRefresh();
        initPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.loadSources();
    }

    // Create the presenter
    private void initPresenter() {
        presenter = new SourcesPresenter(
                Injection.provideRepository(getApplicationContext()),this);
    }

    @Override
    public void showSources(@NonNull List<Source> sources) {
        if (adapter!=null){
            adapter.setSourceList(sources);
        }
    }

    @Override
    public void setRefreshing(final boolean refreshing) {
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(refreshing);
            }
        });
    }

    @Override
    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public void showLoadingSourcesError() {
        setRefreshing(false);
        Toast.makeText(this, R.string.error_load_data, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showNoSourcesData() {
        setRefreshing(false);
        Toast.makeText(this, R.string.empty_list, Toast.LENGTH_SHORT).show();
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setTitle(getTitle());
        }
    }

    private void initRecycler() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(itemAnimator);
        adapter = new SourcesRecyclerViewAdapter(new SourcesRecyclerViewAdapter.ItemClickListener() {
            @Override
            public void onItemClick(Source source) {
                showNewsActivity(source.getId());
            }
        }, new ArrayList<Source>());
        recyclerView.setAdapter(adapter);
    }

    private void showNewsActivity(String sourceId){
        Intent intent = new Intent(this, NewsActivity.class);
        intent.putExtra(NewsActivity.EXTRA_SOURCE_ID, sourceId);
        startActivity(intent);
    }

    private void initSwipeToRefresh() {
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_to_refresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.loadSources();
            }
        });
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
    }
}
