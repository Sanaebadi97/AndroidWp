package sanaebadi.info.ahwazdev.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import sanaebadi.info.ahwazdev.R;

public class AuthorActivity extends BaseActivity {

  @BindView(R.id.img_author_profile)
  ImageView img_author_profile;

  @BindView(R.id.img_github)
  ImageView img_github;

  @BindView(R.id.img_twitter)
  ImageView img_twitter;

  @BindView(R.id.img_linkedin)
  ImageView img_linkedin;

  @BindView(R.id.txt_author_name)
  TextView txt_author_name;

  @BindView(R.id.txt_author_about)
  TextView txt_author_about;

  private String authorImageUrl;
  private String authorName;
  private String authorAbout;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_author);

    ButterKnife.bind(this);

    Intent intent = getIntent();
    authorImageUrl = intent.getStringExtra("AUTHOR_PROFILE");
    authorName = intent.getStringExtra("AUTHOR_NAME");
    authorAbout = intent.getStringExtra("AUTHOR_ABOUT");


    Glide.with(this).clear(img_author_profile);
    Glide.with(this).load(authorImageUrl)
      .into(img_author_profile);

    txt_author_name.setText(authorName);
    txt_author_about.setText(authorAbout);


    //************* Connect Network *************

    //GitHub
    img_github.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        Uri uri = Uri.parse("https://github.com/sanaebadi97"); // missing 'http://' will cause crashed
        startActivity(new Intent(Intent.ACTION_VIEW, uri));

      }
    });

    //Linkedin
    img_linkedin.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        Uri uri = Uri.parse("https://www.linkedin.com/in/sana-ebadi-699a03134"); // missing 'http://' will cause crashed
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
      }
    });

    //Twitter
    img_twitter.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        Uri uri = Uri.parse("https://twitter.com/sanaebadi97?s=09"); // missing 'http://' will cause crashed
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
      }
    });
  }
}
