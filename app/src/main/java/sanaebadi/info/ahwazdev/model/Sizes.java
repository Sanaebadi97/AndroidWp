package sanaebadi.info.ahwazdev.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sanaebadi on 7/9/18.
 */

public class Sizes {

  @SerializedName("full")
  private Full full;

  public Full getFull() {
    return full;
  }

  public void setFull(Full full) {
    this.full = full;
  }
}
