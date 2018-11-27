package com.example.nicodelacruz.drunkentap;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;


public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //get rating bar object
        RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
        bar.setNumStars(5);
        bar.setStepSize(0.5f);
        //get text view
        TextView t=(TextView)findViewById(R.id.textResult);
        //get score
        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");
        //display score
        bar.setRating(score);
        switch (score)
        {
            case 0: t.setText("Obtuviste 0%, Estas muy borracho pide un Uber no te arriesgues");
                break;
            case 1: t.setText("Obtuviste 20%, Estas borracho pide un Uber ");
                break;
            case 2: t.setText("Obtuviste 40%, No estas muy Borracho, quieres pedir un Uber");
                break;
            case 3: t.setText("Obtuviste 60%, Estas bien, sigue pisteando Bro ");
                break;
            case 4:t.setText("Obtuviste 80% Chupale más");
                break;
            case 5:t.setText("Impresionante obtuviste 100%, no estas ebrio campeón");
                break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent settingsIntent = new Intent(this, QuizActivity.class);
            startActivity(settingsIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void Uber (View view){
        Intent UberIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://m.uber.com/ul/?client_id=<CLIENT_ID>"));
        startActivity(UberIntent);
    }

}