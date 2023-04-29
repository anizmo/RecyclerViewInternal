package edu.neu.madcourse.recyclerviewinternal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * This class is an adapter for a RecyclerView that displays a list of Person objects.
 */
public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    private final Context context;

    private final List<Person> persons;

    private final RecyclerViewCallback recyclerViewCallback;

    private int totalCreatedViewHolders;

    /**
     * Constructs a new PersonAdapter with the given context, list of persons, and RecyclerViewCallback.
     *
     * @param context the context
     * @param persons the list of persons
     * @param recyclerViewCallback the RecyclerViewCallback
     */
    public PersonAdapter(Context context, List<Person> persons, RecyclerViewCallback recyclerViewCallback) {
        this.context = context;
        this.persons = persons;
        this.recyclerViewCallback = recyclerViewCallback;
        totalCreatedViewHolders = 0;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        totalCreatedViewHolders++;
        recyclerViewCallback.totalViewHoldersCreated(totalCreatedViewHolders);
        recyclerViewCallback.lastMethodCalled("onCreateViewHolder");
        return new PersonViewHolder(LayoutInflater.from(context).inflate(R.layout.item_person, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        recyclerViewCallback.lastMethodCalled("onBindViewHolder (position = " +position+ ")");
        holder.personName.setText(persons.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    /**
     * This class represents a ViewHolder for a Person object in the RecyclerView.
     */
    static class PersonViewHolder extends RecyclerView.ViewHolder {

        public TextView personName;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            personName = itemView.findViewById(R.id.personName);
        }
    }

}

