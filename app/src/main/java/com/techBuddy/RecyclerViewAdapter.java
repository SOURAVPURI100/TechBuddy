package com.techBuddy;

/**
 * Created by sourav on 9/15/17.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.*;
import android.widget.EditText;
import android.widget.ImageView;
//import android.widget.LinearLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.*;
import com.squareup.picasso.Picasso;

/**
 * Created by sourav on 9/15/17.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder> {
    private List<FeedItem> feedItemList;
    private Context mContext;
    private LinearLayout linearLayout;

    public RecyclerViewAdapter(Context context, List<FeedItem> feedItemList) {
        this.feedItemList = feedItemList;
        this.mContext = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        FeedItem feedItem = feedItemList.get(i);

        //Render image using Picasso library
        if (!TextUtils.isEmpty(feedItem.getThumbnail())) {
            Picasso.with(mContext).load(feedItem.getThumbnail())
                    .error(R.drawable.placeholder)
                    .placeholder(R.drawable.placeholder)
                    .into(customViewHolder.imageView);
        }
//        LinearLayout linearLayout = (LinearLayout) customViewHolder.linearLayout;
//        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.MATCH_PARENT));
//
//        linearLayout.setOrientation(LinearLayout.VERTICAL);
//        linearLayout.setBackgroundColor(0xff99ccff);
//
//        linearLayout = customViewHolder.linearLayout;
//
//        // Add textviews
//        TextView textView1 = new TextView(mContext.getApplicationContext());
//        textView1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT));
//        textView1.setText("programmatically");
//        textView1.setBackgroundColor(0xff66ff66); // hex color 0xAARRGGBB
//        textView1.setPadding(5, 5, 5, 5); // in pixels (left, top, right, bottom)
//        linearLayout.addView(textView1);
//
//        TextView textView2 = new TextView(mContext.getApplicationContext());
//        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT);
//        layoutParams.setMargins(10, 10, 10, 10); // (left, top, right, bottom)
//        textView2.setLayoutParams(layoutParams);
//        textView2.setText("p");
//        textView2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
//        textView2.setBackgroundColor(0xffffdbdb); // hex color 0xAARRGGBB
//        linearLayout.addView(textView2);

        //Setting text view title
        //customViewHolder.textView.setText(Html.fromHtml(feedItem.getTitle()));

        customViewHolder.name.setText("Sourav Puri");
        customViewHolder.field.setText("Java; JavaScript; Java; JavaScript; Java; JavaScript \n Python;");
        customViewHolder.project.setText("Project : Looking to learn Java. I am a beginner in Java.");
    }

    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected ImageView imageView;
        protected TextView textView;
        protected LinearLayout linearLayout;
        protected TextView name;
        protected TextView field;
        protected TextView project;

        public CustomViewHolder(View view) {
            super(view);
            this.imageView = (ImageView) view.findViewById(R.id.thumbnail);
            //this.textView = (TextView) view.findViewById(R.id.title);
//            this.linearLayout = (LinearLayout) view.findViewById(R.id.textLayout);
//            linearLayout = this.linearLayout;
            this.name = (TextView) view.findViewById(R.id.name);
            this.field = (TextView) view.findViewById(R.id.field);
            this.project = (TextView) view.findViewById(R.id.project);

        }
    }
}
