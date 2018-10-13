package sanaebadi.info.ahwazdev.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sanaebadi.info.ahwazdev.R;
import sanaebadi.info.ahwazdev.activity.AuthorActivity;
import sanaebadi.info.ahwazdev.activity.DetailsActivity;
import sanaebadi.info.ahwazdev.handler.CustomClickListener;
import sanaebadi.info.ahwazdev.model.PostData;

/**
 * Created by sanaebadi on 7/8/18.
 */

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder> {

  private static final String TAG = "PostsAdapter";
  private Context context;
  private List<PostData> postDataList;
  private PostData postData;
  private CustomClickListener listener;

  public PostsAdapter(Context context, List<PostData> postDataList, CustomClickListener listener) {
    this.context = context;
    this.postDataList = postDataList;
    this.listener = listener;
  }

  @NonNull
  @Override
  public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    
   final View view = LayoutInflater.from(context).inflate(R.layout.post_row, parent, false);
    final PostsViewHolder postsViewHolder = new PostsViewHolder(view);

    view.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        listener.itemClick(view, postsViewHolder.getLayoutPosition());
      }
    });

    return postsViewHolder;
  }
  
  @Override
  public void onBindViewHolder(@NonNull final PostsViewHolder holder, int position) {

    postData = postDataList.get(position);

    holder.txt_date.setText(postData.getPostDate());
    holder.txt_title.setText(postData.getTitle().getTitleRendered());
    holder.txt_content.setText(Html.fromHtml(postData.getPostContent().getContentRendered()));

    holder.txt_author.setText(postData.getPostEmbedded().getAuthor().get(0).getName());


    //Posts Image

    Glide.with(context).clear(holder.img_post);
    Glide.with(context).load(postData.getPostEmbedded().getWpFeaturedmedia().get(0).getMediaDetails().getSizes()
      .getFull().getSourceUrl())
      .into(holder.img_post);

    //Author Profile

    Glide.with(context).clear(holder.img_author_profile);
    Glide.with(context).load(postData.getPostEmbedded().getAuthor().get(0).getAvatarUrls().getAuthorAvatar())
      .into(holder.img_author_profile);


    holder.author_lay.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        Intent intent = new Intent(context, AuthorActivity.class);
        intent.putExtra("AUTHOR_PROFILE", postData.getPostEmbedded().getAuthor().get(0).getAvatarUrls().getAuthorAvatar());
        intent.putExtra("AUTHOR_NAME", postData.getPostEmbedded().getAuthor().get(0).getName());
        intent.putExtra("AUTHOR_ABOUT", postData.getPostEmbedded().getAuthor().get(0).getDescription());
        context.startActivity(intent);


      }
    });

  /*  holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        Intent intent = new Intent(context, DetailsActivity.class);

        intent.putExtra("POST_ID", postData.getId());
        intent.putExtra("POST_TITLE", postData.getTitle().getTitleRendered());
        intent.putExtra("POST_CONTENT", postData.getPostContent().getContentRendered());
        intent.putExtra("POST_IMAGE", postData.getPostEmbedded().getWpFeaturedmedia().get(0).getMediaDetails().getSizes()
          .getFull().getSourceUrl());

        context.startActivity(intent);


      }
    });*/

    holder.img_popup.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        showPopupMenu(holder.img_popup);
      }
    });

  }


  /**
   * Showing popup menu when tapping on 3 dots
   */
  private void showPopupMenu(View view) {
    // inflate menu
    PopupMenu popup = new PopupMenu(context, view);
    MenuInflater inflater = popup.getMenuInflater();
    inflater.inflate(R.menu.main_menu, popup.getMenu());
    popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
    popup.show();
  }

  /**
   * Click listener for popup menu items
   */
  class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

    public MyMenuItemClickListener() {
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
      switch (menuItem.getItemId()) {

        case R.id.share:

          Intent sendIntent = new Intent();
          sendIntent.setAction(Intent.ACTION_SEND);
          sendIntent.putExtra(Intent.EXTRA_TEXT,
            Html.fromHtml(postData.getPostContent().getContentRendered()));
          sendIntent.setType("text/plain");
          context.startActivity(sendIntent);


          break;

        default:
      }
      return false;
    }
  }


  @Override
  public int getItemCount() {

    try {
      return postDataList.size();
    } catch (Exception e) {
      return 0;
    }
  }


  public class PostsViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.txt_title)
    TextView txt_title;

    @BindView(R.id.txt_date)
    TextView txt_date;

    @BindView(R.id.txt_content)
    TextView txt_content;

    @BindView(R.id.txt_author)
    TextView txt_author;

    @BindView(R.id.img_post)
    ImageView img_post;

    @BindView(R.id.img_author_profile)
    ImageView img_author_profile;

    @BindView(R.id.img_popup)
    ImageView img_popup;

    @BindView(R.id.author_lay)
    RelativeLayout author_lay;


    public PostsViewHolder(View itemView) {
      super(itemView);

      ButterKnife.bind(this, itemView);

      Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/bzar.ttf");
      txt_date.setTypeface(typeface);
    }

  }

}
