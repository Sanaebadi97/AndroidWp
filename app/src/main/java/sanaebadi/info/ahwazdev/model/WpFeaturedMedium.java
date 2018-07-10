package sanaebadi.info.ahwazdev.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sanaebadi on 7/9/18.
 */

public class WpFeaturedMedium {

  @SerializedName("media_details")
  private MediaDetails mediaDetails;

  public MediaDetails getMediaDetails() {
    return mediaDetails;
  }

  public void setMediaDetails(MediaDetails mediaDetails) {
    this.mediaDetails = mediaDetails;
  }
}
