package sanaebadi.info.ahwazdev.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sanaebadi on 7/9/18.
 */

public class Content {

  @SerializedName("rendered")
  @Expose
  private String contentRendered;

  public String getContentRendered() {
    return contentRendered;
  }

  public void setContentRendered(String contentRendered) {
    this.contentRendered = contentRendered;
  }
}
