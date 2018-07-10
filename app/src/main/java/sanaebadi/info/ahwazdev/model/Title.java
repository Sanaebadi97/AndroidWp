package sanaebadi.info.ahwazdev.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sanaebadi on 7/9/18.
 */

public class Title {

  @SerializedName("rendered")
  @Expose
  private String titleRendered;


  public String getTitleRendered() {
    return titleRendered;
  }

  public void setTitleRendered(String titleRendered) {
    this.titleRendered = titleRendered;
  }
}
