package edu.uncw.secretseahawk;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class App extends Application {

    static final List<Person> INITIAL_PEOPLE = new ArrayList<Person>(
            Arrays.asList(
                    new Person("Lois Steem", 35, "Self-help book", true),
                    new Person("Hugh Jass", 46, "Bigger pants", false),
                    new Person("Poupon Degrasse", 28, "French dogwalker's guide", false)
            )
    );

    private BoxStore boxStore;

    @Override
    public void onCreate() {
        super.onCreate();
        boxStore = MyObjectBox.builder().androidContext(App.this).build();
        Box<Person> personBox = boxStore.boxFor(Person.class);
        if(personBox.count() == 0) {
            personBox.put(INITIAL_PEOPLE);
        }
    }

    public BoxStore getBoxStore() {
        return boxStore;
    }
}
