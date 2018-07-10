package sanaebadi.info.ahwazdev.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sanaebadi on 7/8/18.
 */

public class PostData {


  @SerializedName("id")
  @Expose
  private int id;

  @SerializedName("date")
  @Expose
  private String postDate;

  @SerializedName("title")
  @Expose
  private Title postTitle;

  @SerializedName("content")
  @Expose
  private Content postContent;


  @SerializedName("_embedded")
  @Expose
  private Embedded postEmbedded;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getPostDate() {
    return postDate;
  }

  public void setPostDate(String postDate) {
    this.postDate = postDate;
  }

  public Title getTitle() {
    return postTitle;
  }

  public void setTitle(Title title) {
    this.postTitle = title;
  }

  public Title getPostTitle() {
    return postTitle;
  }

  public void setPostTitle(Title postTitle) {
    this.postTitle = postTitle;
  }

  public Content getPostContent() {
    return postContent;
  }

  public void setPostContent(Content postContent) {
    this.postContent = postContent;
  }

  public Embedded getPostEmbedded() {
    return postEmbedded;
  }

  public void setPostEmbedded(Embedded postEmbedded) {
    this.postEmbedded = postEmbedded;
  }
}
