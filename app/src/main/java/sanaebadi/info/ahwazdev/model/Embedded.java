package sanaebadi.info.ahwazdev.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sanaebadi on 7/9/18.
 */

public class Embedded {

  @SerializedName("author")
  @Expose
  private List<Author> author = null;
  @SerializedName("wp:featuredmedia")
  @Expose
  private List<WpFeaturedMedium> wpFeaturedmedia = null;

  public List<Author> getAuthor() {
    return author;
  }

  public void setAuthor(List<Author> author) {
    this.author = author;
  }

  public List<WpFeaturedMedium> getWpFeaturedmedia() {
    return wpFeaturedmedia;
  }

  public void setWpFeaturedmedia(List<WpFeaturedMedium> wpFeaturedmedia) {
    this.wpFeaturedmedia = wpFeaturedmedia;
  }

}
