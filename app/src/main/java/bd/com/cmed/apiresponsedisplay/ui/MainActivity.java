package bd.com.cmed.apiresponsedisplay.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

import bd.com.cmed.apiresponsedisplay.App;
import bd.com.cmed.apiresponsedisplay.R;
import bd.com.cmed.apiresponsedisplay.model.BaseResponse;
import bd.com.cmed.apiresponsedisplay.model.users;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        App.getApp().getWebService().getUserList().enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {

                progressBar.setVisibility(View.GONE);
                setupRecyclerWithData(response.body().getUsersList());
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                Log.e("ApiCallFail", t.getMessage());
            }
        });
    }

    private void init(){
        recyclerView = findViewById(R.id.rv_users_list);
        progressBar = findViewById(R.id.progressBar);
    }

    private void setupRecyclerWithData(List<users> usersList){
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this, LinearLayoutManager.VERTICAL));

        UsersListAdapter mAdapter = new UsersListAdapter(usersList, MainActivity.this);
        recyclerView.setAdapter(mAdapter);
    }
}
