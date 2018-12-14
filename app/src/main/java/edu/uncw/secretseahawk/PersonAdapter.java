package edu.uncw.secretseahawk;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import io.objectbox.Box;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    private Box<Person> personBox;
    private Listener listener;

    interface Listener {
        /**
         * This method is called when a Person is clicked in the list.
         *
         * @param position the position of the Person in the list
         */
        void onClick(int position);
    }

    void setListener(Listener listener) {
        this.listener = listener;
    }

    PersonAdapter(Box<Person> personBox) {
        this.personBox = personBox;
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder {
        public View layout;
        ImageView doneView;
        TextView nameView;
        TextView giftView;
        TextView ageView;

        public PersonViewHolder(View v) {
            super(v);
            layout = v;
            doneView = v.findViewById(R.id.done);
            nameView = v.findViewById(R.id.name);
            giftView = v.findViewById(R.id.gift);
            ageView = v.findViewById(R.id.age);
        }
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_list_item, viewGroup, false);
        return new PersonViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, final int position) {
        Person person = personBox.getAll().get(position);

        holder.doneView.setImageResource(person.getDone() ? R.drawable.checked : R.drawable.unchecked);
        holder.nameView.setText(person.getName());
        holder.giftView.setText(person.getGift());
        holder.ageView.setText(String.format("%3d",person.getAge()));

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onClick(position);
                }
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return (int) personBox.count();
    }
}
