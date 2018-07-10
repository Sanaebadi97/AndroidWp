package sanaebadi.info.ahwazdev.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sanaebadi on 7/9/18.
 */

public class Full {

  @SerializedName("file")
  private String file;

  @SerializedName("width")
  private Integer width;

  @SerializedName("height")
  private Integer height;

  @SerializedName("mime_type")
  private String mimeType;

  @SerializedName("source_url")
  private String sourceUrl;

  public String getFile() {
    return file;
  }

  public void setFile(String file) {
    this.file = file;
  }

  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public String getMimeType() {
    return mimeType;
  }

  public void setMimeType(String mimeType) {
    this.mimeType = mimeType;
  }

  public String getSourceUrl() {
    return sourceUrl;
  }

  public void setSourceUrl(String sourceUrl) {
    this.sourceUrl = sourceUrl;
  }


}
