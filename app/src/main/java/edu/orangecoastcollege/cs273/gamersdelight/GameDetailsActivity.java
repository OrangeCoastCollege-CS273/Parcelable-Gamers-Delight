package edu.orangecoastcollege.cs273.gamersdelight;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;


public class GameDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_details);

        ImageView gameDetailsImageView = (ImageView) findViewById(R.id.gameDetailsImageView);
        TextView gameDetailsNameTextView = (TextView) findViewById(R.id.gameDetailsNameTextView);
        TextView gameDetailsDescriptionTextView = (TextView) findViewById(R.id.gameDetailsDescriptionTextView);
        RatingBar gameDetailsRatingBar = (RatingBar) findViewById(R.id.gameDetailsRatingBar);


        Game game = getIntent().getParcelableExtra("game");

        AssetManager am = this.getAssets();
        try {
            Log.i("BOI?", "onCreate: " + game.getImageName());
            InputStream stream = am.open(game.getImageName());
            Drawable event = Drawable.createFromStream(stream, game.getName());
            gameDetailsImageView.setImageDrawable(event);
        }
        catch (IOException ex)
        {
            Log.e("Gamers Delight", "Error loading " + game.getImageName(), ex);
        }

        gameDetailsNameTextView.setText(game.getName());
        gameDetailsDescriptionTextView.setText(game.getDescription());
        gameDetailsRatingBar.setRating( game.getRating());
    }
}
