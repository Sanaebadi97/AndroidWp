package sanaebadi.info.ahwazdev.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sanaebadi on 7/9/18.
 */

public class MediaDetails {

  @SerializedName("file")
  private String file;

  @SerializedName("sizes")
  private Sizes sizes;

  public String getFile() {
    return file;
  }

  public void setFile(String file) {
    this.file = file;
  }

  public Sizes getSizes() {
    return sizes;
  }

  public void setSizes(Sizes sizes) {
    this.sizes = sizes;
  }

}
