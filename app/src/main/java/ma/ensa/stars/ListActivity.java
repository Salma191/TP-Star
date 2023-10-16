package ma.ensa.stars;


import static android.service.controls.ControlsProviderService.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

import ma.ensa.stars.R;
import ma.ensa.stars.adapter.StarAdapter;
import ma.ensa.stars.beans.Star;
import ma.ensa.stars.service.StarService;

public class ListActivity extends AppCompatActivity {
    StarService service = StarService.getInstance();
    private List<Star> stars;
    private RecyclerView recyclerView;
    private StarAdapter starAdapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        stars = new ArrayList<>();
        service = StarService.getInstance();
        init();
        recyclerView = findViewById(R.id.recycle_view);
        starAdapter = new StarAdapter(this, service.findAll());
        recyclerView.setAdapter(starAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    public void init(){
        service.create(new Star("Johnny Deep", R.mipmap.johnnydepp, 3.5f));
        service.create(new Star("George Clooney", R.mipmap.george, 3));
        service.create(new Star("Angelina Jolie", R.mipmap.angelina, 4));
        service.create(new Star("Kate Bosworth", R.mipmap.kate, 1));
        service.create(new Star("Brad Pitt",R.mipmap.braddpitt , 2.5f));
        service.create(new Star("louise bouroin", R.mipmap.braddpitt, 1));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem menuItem = menu.findItem(R.id.app_bar_search);
        SearchView searchView = (SearchView)
                MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d(TAG, newText);
                return true;
            }
        });
        return true;
    }
}