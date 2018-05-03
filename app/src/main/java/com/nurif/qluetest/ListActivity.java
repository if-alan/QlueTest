package com.nurif.qluetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.nurif.qluetest.adapter.ListAdapter;
import com.nurif.qluetest.model.QlueModel;
import com.nurif.qluetest.server.APIUtils;
import com.nurif.qluetest.server.QlueService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private QlueService mService;

    private ListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mService = APIUtils.getQlueService();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        mAdapter = new ListAdapter(this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);

        loadData();
    }

    public void loadData() {
        mService.getData().enqueue(new Callback<List<QlueModel>>() {
            @Override
            public void onResponse(Call<List<QlueModel>> call, Response<List<QlueModel>> response) {
                if (response.isSuccessful()) {
                    mAdapter.setItems(response.body());
                } else {
                    int statusCode = response.code();
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<List<QlueModel>> call, Throwable t) {
            }
        });
    }
}
