package sanaebadi.info.ahwazdev.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import sanaebadi.info.ahwazdev.R;

public class DetailsActivity extends BaseActivity {

  private static final String TAG = "DetailsActivity";

  @BindView(R.id.txt_title)
   TextView txt_title;

  @BindView(R.id.txt_content)
   TextView txt_content;

  @BindView(R.id.img_post)
   ImageView img_post;

  private int id;
  private String title;
  private String content;
  private String imageUrl;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_details);

    ButterKnife.bind(this);

    Intent intent = getIntent();
    id = intent.getIntExtra("POST_ID", 0);
    title = intent.getStringExtra("POST_TITLE");
    content = intent.getStringExtra("POST_CONTENT");
    imageUrl = intent.getStringExtra("POST_IMAGE");


    txt_title.setText(title);
    txt_content.setText(Html.fromHtml(content));

    Glide.with(this).clear(img_post);

    Glide.with(this).load(imageUrl)
      .into(img_post);


  }
}
