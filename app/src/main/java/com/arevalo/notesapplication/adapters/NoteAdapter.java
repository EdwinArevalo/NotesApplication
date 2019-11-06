package com.arevalo.notesapplication.adapters;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arevalo.notesapplication.R;
import com.arevalo.notesapplication.models.Note;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    private List<Note> notes;

    public NoteAdapter(List<Note> notes) {
        this.notes = notes;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView description;

        public ViewHolder(View itemView) {
            super(itemView);
            title =(TextView) itemView.findViewById(R.id.title_text);
            description = (TextView) itemView.findViewById(R.id.description_text);
        }
    }

    @Override
    public NoteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notes, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NoteAdapter.ViewHolder viewHolder, int position) {
        Note user = this.notes.get(position);
        viewHolder.title.setText(user.getTitle());
        viewHolder.description.setText(user.getDescription());
    }

    @Override
    public int getItemCount() {
        return this.notes.size();
    }
}
