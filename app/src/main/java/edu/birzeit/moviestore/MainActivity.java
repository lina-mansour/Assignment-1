package edu.birzeit.moviestore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private Spinner spinner1;
    private EditText editText1;
    private EditText editText2;


    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        spinner1 = findViewById(R.id.spinner1);
        populateSpinner();
        editText1 = findViewById(R.id.edtTxt1);
        editText2 = findViewById(R.id.edtTxt2);
    }
    private void populateSpinner() {
        MovieFactory factory = new MovieFactory();
        IMovieData objMovie = factory.getModel();

        String[] genres = objMovie.getGenres();
        String[] years = objMovie.getYears();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, genres);
        spinner.setAdapter(adapter);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, years);
        spinner1.setAdapter(adapter1);

    }

    public void btnGetMoviesOnClick(View view) {

        MovieFactory factory = new MovieFactory();
        IMovieData objBook = factory.getModel();

        Movie target = new Movie();

        target.setGenre(spinner.getSelectedItem().toString());
        target.setYear(spinner1.getSelectedItem().toString());
        target.setTitle(editText1.getText().toString());

        List<Movie> movies = objBook.searchMovie(target);

        String str = "";
        for(Movie m: movies){
            str+=m.getTitle() + "\n";
        }

        editText2.setText(str);

    }
}