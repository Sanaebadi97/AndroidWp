package sanaebadi.info.ahwazdev.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sanaebadi on 7/9/18.
 */

public class Author {
  @SerializedName("id")
  private Integer id;

  @SerializedName("name")
  private String name;

  @SerializedName("url")
  private String url;

  @SerializedName("description")
  private String description;

  @SerializedName("link")
  private String link;

  @SerializedName("slug")
  private String slug;

  @SerializedName("avatar_urls")
  private AvatarUrls avatarUrls;



  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }


  public AvatarUrls getAvatarUrls() {
    return avatarUrls;
  }

  public void setAvatarUrls(AvatarUrls avatarUrls) {
    this.avatarUrls = avatarUrls;
  }
}
