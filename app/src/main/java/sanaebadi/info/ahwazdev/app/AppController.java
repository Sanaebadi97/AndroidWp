package sanaebadi.info.ahwazdev.app;

import android.app.Application;

import sanaebadi.info.ahwazdev.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by sanaebadi on 7/9/18.
 */

public class AppController extends Application {
  @Override
  public void onCreate() {
    super.onCreate();

    CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
      .setDefaultFontPath("fonts/bzar.ttf")
      .setFontAttrId(R.attr.fontPath)
      .build()
    );
  }
}
