package edu.neu.madcourse.recyclerviewinternal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * The MainActivity class is the main activity of the application. It displays a RecyclerView that contains a list of Person objects.
 * The RecyclerView is created using an instance of the PersonAdapter class.
 *
 * The class implements the RecyclerViewCallback interface to receive callbacks from the PersonAdapter class.
 * It also contains methods for generating RecyclerView items and updating the UI based on the callbacks received.
 */
public class MainActivity extends AppCompatActivity implements RecyclerViewCallback {

    /**
     * TextView to display the total number of ViewHolders created by the RecyclerView.
     */
    private TextView totalViewHoldersCreated;

    /**
     * TextView to display the name of the last method called by the RecyclerView.
     */
    private TextView lastMethodCalled;

    /**
     * EditText to input the number of RecyclerView items to be generated.
     */
    private EditText itemCountEditText;

    /**
     * List of Person objects to be displayed in the RecyclerView.
     */
    private List<Person> persons;

    /**
     * Instance of the PersonAdapter class used to create the RecyclerView.
     */
    PersonAdapter adapter;

    /**
     * Called when the activity is starting. It sets the content view to the activity_main layout.
     * It initializes UI elements, generates RecyclerView items, and sets up the RecyclerView with its adapter and layout manager.
     *
     * @param savedInstanceState A Bundle object containing the activity's previously saved state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        totalViewHoldersCreated = findViewById(R.id.totalViewHoldersCreated);
        lastMethodCalled = findViewById(R.id.lastMethodCalled);
        itemCountEditText = findViewById(R.id.itemsEditText);
        Button changeItemCountButton = findViewById(R.id.changeitemsCountButton);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        persons = new ArrayList<>();

        // Generate initial RecyclerView items
        int itemCount1 = 7;
        itemCountEditText.setText(String.valueOf(itemCount1));
        generateRecyclerViewItems(itemCount1);

        // Set onClickListener for the changeItemCountButton to generate new RecyclerView items based on user input
        changeItemCountButton.setOnClickListener(view -> {
            int itemCount = Integer.parseInt(itemCountEditText.getText().toString());
            generateRecyclerViewItems(itemCount);
        });

        // Set up the RecyclerView with its adapter and layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    /**
     * Updates the totalViewHoldersCreated TextView with the number of ViewHolders created by the RecyclerView.
     *
     * @param viewHoldersCreated The total number of ViewHolders created by the RecyclerView.
     */
    @Override
    public void totalViewHoldersCreated(int viewHoldersCreated) {
        totalViewHoldersCreated.setText("Total View Holders Created = " + viewHoldersCreated);
    }

    /**
     * Updates the lastMethodCalled TextView with the name of the last method called by the RecyclerView.
     *
     * @param methodName The name of the last method called by the RecyclerView.
     */
    @Override
    public void lastMethodCalled(String methodName) {
        lastMethodCalled.setText("Last Method Called\n" + methodName);
    }

    /**
     * Clears the persons list, generates new Person objects, and sets the adapter to a new instance of the PersonAdapter class with the updated persons list.
     * It also calls notifyDataSetChanged() on the adapter to update the RecyclerView.
     *
     * @param noOfItems The number of Person objects to generate.
     */
    private void generateRecyclerViewItems(int noOfItems) {
        persons.clear();
        adapter = new PersonAdapter(this, persons, this);
        // Create the set number of person items.
        for (int i = 0; i < noOfItems; i++) {
            persons.add(new Person("Person " + (i+1)));
        }
        adapter.notifyDataSetChanged();
    }

}