package com.arevalo.notesapplication.adapters;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.arevalo.notesapplication.R;
import com.arevalo.notesapplication.models.Note;
import com.arevalo.notesapplication.repositories.NoteRepository;
import com.orm.SugarRecord;

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
        public Button doArchived, doFavorite;

        public ViewHolder(View itemView) {
            super(itemView);
            title =(TextView) itemView.findViewById(R.id.title_text);
            description = (TextView) itemView.findViewById(R.id.description_text);
            doArchived = (Button) itemView.findViewById(R.id.doArchived_button);
            doFavorite = (Button) itemView.findViewById(R.id.doFavorite_button);
        }
    }

    @Override
    public NoteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notes, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final NoteAdapter.ViewHolder viewHolder, final int position) {
        final Note note = this.notes.get(position);
        viewHolder.title.setText(note.getTitle());
        viewHolder.description.setText(note.getDescription());

        //seteamos como archivado y ocultamos el item
        viewHolder.doArchived.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                notes.get(position).setEstado(2);
                SugarRecord.save(notes.get(position));
                notes.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, getItemCount());
            }

        });

        //seteamos como favorito
        viewHolder.doFavorite.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                notes.get(position).setEstado(1);
                SugarRecord.save(notes.get(position));
            }
        });


    }

    @Override
    public int getItemCount() {
        return this.notes.size();
    }
}
