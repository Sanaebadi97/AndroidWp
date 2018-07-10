package sanaebadi.info.ahwazdev.rest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import sanaebadi.info.ahwazdev.model.PostData;

/**
 * Created by sanaebadi on 7/7/18.
 */

public interface ApiInterface {

  @GET("posts?_embed")
  Call<List<PostData>> getPostData();
}
