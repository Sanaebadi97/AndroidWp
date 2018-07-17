package sanaebadi.info.ahwazdev.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sanaebadi.info.ahwazdev.R;
import sanaebadi.info.ahwazdev.model.Author;

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


    //************* Connect SocialMedia *************

//    //GitHub
//    img_github.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View v) {
//
//        Uri uri = Uri.parse("https://github.com/sanaebadi97"); // missing 'http://' will cause crashed
//        startActivity(new Intent(Intent.ACTION_VIEW, uri));
//
//      }
//    });
//
//    //Linkedin
//    img_linkedin.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View v) {
//
//        Uri uri = Uri.parse("https://www.linkedin.com/in/sana-ebadi-699a03134"); // missing 'http://' will cause crashed
//        startActivity(new Intent(Intent.ACTION_VIEW, uri));
//      }
//    });
//
//    //Twitter
//    img_twitter.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View v) {
//
//        Uri uri = Uri.parse("https://twitter.com/sanaebadi97?s=09"); // missing 'http://' will cause crashed
//        startActivity(new Intent(Intent.ACTION_VIEW, uri));
//      }
//
//  });


  }

  //************* Connect SocialMedia  ButterKnife *************

  @OnClick({R.id.img_github,
    R.id.img_linkedin, R.id.img_twitter
  })
  void onConnectionView(ImageView imgSocialMedia) {

    switch (imgSocialMedia.getId()) {

      //GitHub
      case R.id.img_github:

        Uri uriGithub = Uri.parse("https://github.com/sanaebadi97"); // missing 'http://' will cause crashed
        startActivity(new Intent(Intent.ACTION_VIEW, uriGithub));

        break;

      //Linkedin
      case R.id.img_linkedin:

        Uri uriLinkedin = Uri.parse("https://www.linkedin.com/in/sana-ebadi-699a03134"); // missing 'http://' will cause crashed
        startActivity(new Intent(Intent.ACTION_VIEW, uriLinkedin));

        break;

      //Twitter
      case R.id.img_twitter:

        Uri uriTwitter = Uri.parse("https://twitter.com/sanaebadi97?s=09"); // missing 'http://' will cause crashed
        startActivity(new Intent(Intent.ACTION_VIEW, uriTwitter));

        break;

    }


  }

}
