package com.example.dexter.practiceproject;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class PracticeProject extends Activity {
    //create an arrayList called myMovies that will get its data from movies.java(this is seen in the
    //statement; "...List<movie> myMovies..."
    private List<movies> myMovies = new ArrayList<movies>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practice_project_layout);

        //Populates the movieList
        populateMovieList();

        //Populates the ListView
        populateListView();

        //Causes an action to occur after something on the list has been clicked
        registerClickCallBack();
    }

    private void registerClickCallBack() {
        ListView list = (ListView) findViewById(R.id.moviesListView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                movies clickedmovies = myMovies.get(position);
                String message = "You clicked position" + position
                        + "which is the movie called " + clickedmovies.getName();
                Toast.makeText(PracticeProject.this, message, Toast.LENGTH_LONG).show();

            }
        });
    }

    private void populateListView() {
        //Sets the list to get data from the adapter which in turn gets data from movie.java class
        //which is used to store the data
        ArrayAdapter<movies> adapter = new myListAdapter();
        ListView list = (ListView) findViewById(R.id.moviesListView);
        list.setAdapter(adapter);
    }

    private void populateMovieList() {
        //Populate the movieList
        myMovies.add(new movies("Antman", "Action, sci-fi", R.drawable.antman));
        myMovies.add(new movies("Android*", "Documentary", R.drawable.ic_launcher));
        myMovies.add(new movies("Batman vs superman", "Action, sci-fi", R.drawable.batmanvsuperman));
        myMovies.add(new movies("Situation 'CRITICAL'*", "Action", R.drawable.critical));
        myMovies.add(new movies("Danger*", "Horror", R.drawable.danger));
        myMovies.add(new movies("Deadpool", "Action", R.drawable.deadpool));
        myMovies.add(new movies("Fantastic 4", "Action, sci-fi", R.drawable.fantastic4));
        //myMovies.add(new movies("FIFA: the movie*", "Sports", R.drawable.fifa));
        //myMovies.add(new movies("Need for speed", "Action", R.drawable.nfs));
        myMovies.add(new movies("Point Break", "Action", R.drawable.pointbreak));
        //myMovies.add(new movies("The martian", "Sci-fi", R.drawable.astro));
        myMovies.add(new movies("The 5th wave", "Action", R.drawable.fifthwave));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.practice_project_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class myListAdapter extends ArrayAdapter<movies> {
        public myListAdapter() {
            super(PracticeProject.this, R.layout.item_view, myMovies);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //Make sure we have a view to work with (it may have been given the value "null")
            View itemView = convertView;
            if (itemView == null) {
                itemView = getLayoutInflater().inflate(R.layout.item_view, parent, false);
            }

            //find the movie name to work with
            movies currentmovies = myMovies.get(position);

            //fill the view with the image/icon
            ImageView imageView = (ImageView)itemView.findViewById(R.id.item_icon);
            imageView.setImageResource(currentmovies.getIcon());

            //movie name
            TextView movieNameText = (TextView) itemView.findViewById(R.id.item_txtname);
            movieNameText.setText(currentmovies.getName());

            //genre
            TextView genreText = (TextView) itemView.findViewById(R.id.item_txtgenre);
            genreText.setText(currentmovies.getGenre());


            return itemView;
        }
    }

    public  void start_show_pic_activity (View v) {
        //Trying to get the text from the textView and putting it in the putExtra
        TextView theName = (TextView) findViewById(R.id.item_txtname);
        String theData = theName.getText().toString();
        String value = String.valueOf(theData);

        Intent intent = new Intent(this, ShowPic.class);
        intent.putExtra("parameter name", value);
        startActivity(intent);
    }
}
