package sanaebadi.info.ahwazdev.activity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sanaebadi.info.ahwazdev.R;

public class NetworkActivity extends BaseActivity {


  @BindView(R.id.btn_try_again)
  Button btn_try_again;

  @BindView(R.id.coordinatorLayout)
  CoordinatorLayout coordinatorLayout;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_network);

    ButterKnife.bind(this);


   /* btn_network_setting.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
      }
    });*/
//
//    btn_try_again.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View v) {
//
//        if (isNetworkAvailable()) {
//          startActivity(new Intent(NetworkActivity.this, MainActivity.class));
//
//        } else {
//
//          Snackbar snackbar = Snackbar
//            .make(coordinatorLayout, "خطا در اتصال به اینترنت ", Snackbar.LENGTH_INDEFINITE)
//            .setAction("تنظیمات", new View.OnClickListener() {
//              @Override
//              public void onClick(View view) {
//                startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
//              }
//            });
//
//          ViewCompat.setLayoutDirection(snackbar.getView(), ViewCompat.LAYOUT_DIRECTION_RTL);
//
//          snackbar.show();
//        }
//      }
//    });


  }


  //****************** Click On Try Again Button By ButterKnife ******
  @OnClick(R.id.btn_try_again)
  void tryButton() {

    if (isNetworkAvailable()) {
      startActivity(new Intent(NetworkActivity.this, MainActivity.class));

    } else {

      Snackbar snackbar = Snackbar
        .make(coordinatorLayout, "خطا در اتصال به اینترنت ", Snackbar.LENGTH_INDEFINITE)
        .setAction("تنظیمات", new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
          }
        });

      ViewCompat.setLayoutDirection(snackbar.getView(), ViewCompat.LAYOUT_DIRECTION_RTL);

      snackbar.show();
    }
  }


  private boolean isNetworkAvailable() {
    ConnectivityManager connectivityManager
      = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
  }

}


