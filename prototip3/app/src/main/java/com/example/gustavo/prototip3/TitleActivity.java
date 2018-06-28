package com.example.gustavo.prototip3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class TitleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        ImageView profileImageView = findViewById(R.id.profileImageView);
        TextView userNameTextView =  findViewById(R.id.titleTextView);
        //ImageButton shareProfile = (ImageButton) findViewById(R.id.shareProfile);
        TextView movieUrl =  findViewById(R.id.movieUrl);
        TextView sinopse = findViewById(R.id.sinopse);


        Intent intent = getIntent();
        final String userName = intent.getStringExtra(MovieAdapter.KEY_NAME);
        String image = intent.getStringExtra(MovieAdapter.KEY_IMAGE);
        final String profileUrl = intent.getStringExtra(MovieAdapter.KEY_URL);
        final String sinopseUrl = intent.getStringExtra(MovieAdapter.KEY_SINOPSE);


        Picasso.with(this)
                .load(image)
                .into(profileImageView);

        userNameTextView.setText(userName);
        sinopse.setText(sinopseUrl);
        movieUrl.setText(profileUrl);

        movieUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = profileUrl;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });





/*

        shareProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this awesome developer " + userName +
                        ", " + profileUrl);
                Intent chooser = Intent.createChooser(shareIntent, "Share via");
                if (shareIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(chooser);
                }
            }
        });
*/

    }
}