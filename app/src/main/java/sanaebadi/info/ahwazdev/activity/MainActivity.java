package sanaebadi.info.ahwazdev.activity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sanaebadi.info.ahwazdev.R;
import sanaebadi.info.ahwazdev.adapter.PostsAdapter;
import sanaebadi.info.ahwazdev.handler.CustomClickListener;
import sanaebadi.info.ahwazdev.model.PostData;
import sanaebadi.info.ahwazdev.rest.ApiClient;
import sanaebadi.info.ahwazdev.rest.ApiInterface;

public class MainActivity extends BaseActivity {

  private static final String TAG = "MainActivity";

  private ApiInterface apiInterface;
  private Call<List<PostData>> postCall;
  private List<PostData> postDataList;


  //Views
  @BindView(R.id.posts_list)
  RecyclerView posts_list;

  @BindView(R.id.progress_load)
  ProgressBar progress_load;

  @BindView(R.id.toolbar)
  Toolbar toolbar;

  @BindView(R.id.img_menu)
  ImageView img_menu;

  @BindView(R.id.drawer_layout)
  DrawerLayout drawer_layout;

  @BindView(R.id.nav_view)
  NavigationView nav_view;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ButterKnife.bind(this);
    setSupportActionBar(toolbar);
    getSupportActionBar().setTitle("");


    if (isNetworkAvailable()) {

      //Toast.makeText(this, "You are Connect To Network", Toast.LENGTH_SHORT).show();
    } else {
      // Toast.makeText(this, "You are offline", Toast.LENGTH_SHORT).show();
      startActivity(new Intent(this, NetworkActivity.class));

    }


    getPosts();

//recycler view setup
    posts_list.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
      false));
    posts_list.setHasFixedSize(true);


    //OPen DrawerLayout

    img_menu.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        drawer_layout.openDrawer(GravityCompat.END);
      }
    });


    //NavigationView ItemSelected
    nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
      @Override
      public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

          case R.id.item1:
            Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
            break;

          case R.id.item2:
            Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
            break;

          case R.id.item3:
            Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
            break;

          case R.id.item4:
            Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
            break;

          case R.id.item5:
            Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
            break;

        }
        drawer_layout.closeDrawer(GravityCompat.END);

        return true;
      }
    });
  }


  //get posts
  private void getPosts() {
    apiInterface = ApiClient.createApi();
    postCall = apiInterface.getPostData();

    postCall.enqueue(new Callback<List<PostData>>() {
      @Override
      public void onResponse(Call<List<PostData>> call, Response<List<PostData>> response) {

        progress_load.setVisibility(View.VISIBLE);
        
         postDataList = response.body();

 PostsAdapter postAdapter = new PostsAdapter(MainActivity.this, postDataList, new CustomClickListener() {
          @Override
          public void itemClick(View view, final int position) {


            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            intent.putExtra("POST_ID", postDataList.get(position).getId());
            intent.putExtra("POST_TITLE", postDataList.get(position).getPostTitle().getTitleRendered());
            intent.putExtra("POST_CONTENT", postDataList.get(position).getPostContent().getContentRendered());
            intent.putExtra("POST_IMAGE", postDataList.get(position).getPostEmbedded().
              getWpFeaturedmedia().get(0).getMediaDetails().getSizes().getFull()
              .getSourceUrl());

            startActivity(intent);

          }
        });
        posts_list.setAdapter(postAdapter);

        progress_load.setVisibility(View.GONE);

      }

      @Override
      public void onFailure(Call<List<PostData>> call, Throwable t) {

        progress_load.setVisibility(View.GONE);

        Log.e(TAG, "onFailure: '" + t.getMessage());
        //Toast.makeText(MainActivity.this, "OnFailure: " + t.getMessage(), Toast.LENGTH_SHORT).show();
      }
    });
  }


  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {

      case R.id.item1:
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        break;

      case R.id.item2:
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        break;

      case R.id.item3:
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        break;

      case R.id.item4:
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        break;

      case R.id.item5:
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        break;
    }

    return super.onOptionsItemSelected(item);
  }

  @Override
  public void onBackPressed() {
    if (drawer_layout.isDrawerOpen(GravityCompat.END)) {
      drawer_layout.closeDrawer(GravityCompat.END);
    } else {
      super.onBackPressed();
    }
  }

  //Manage Network Connection
  private boolean isNetworkAvailable() {
    ConnectivityManager connectivityManager
      = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
  }
}
