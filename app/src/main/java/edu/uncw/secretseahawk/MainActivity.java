package edu.uncw.secretseahawk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import io.objectbox.Box;

public class MainActivity extends AppCompatActivity implements PersonAdapter.Listener {

    private Box<Person> personBox;
    private PersonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        personBox = ((App) getApplication()).getBoxStore().boxFor(Person.class);
        RecyclerView recyclerView = findViewById(R.id.people_list);
        recyclerView.setLayoutManager(new LinearLayoutManager((this)));
        adapter = new PersonAdapter(personBox);
        adapter.setListener(this);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));

    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_reset) {
            personBox.removeAll();
            personBox.put(App.INITIAL_PEOPLE);
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "List successfully reset.", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    /**
     * This method is called when a Person is clicked in the list.
     *
     * @param position the position of the Person in the list
     */
    public void onClick(int position) {
        // TODO: You will need to update this code to do something useful.
        Toast.makeText(this, "Clicked on position " + position, Toast.LENGTH_SHORT).show();

    }

    /**
     * This method is called when the Floating ACtion Button (FAB) is clicked
     *
     * @param view a reference to the FAB that was clicked
     */
    public void addPerson(View view) {
        // TODO: You will need to update this code to do something useful.
        Toast.makeText(this, "Clicked on the FAB", Toast.LENGTH_SHORT).show();

    }
}
