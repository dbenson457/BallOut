package uk.aston.ballout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class SessionViewHolder extends RecyclerView.ViewHolder {
    private final TextView sessionItemView;

    public SessionViewHolder(@NonNull View itemView) {
        super(itemView);
        sessionItemView = itemView.findViewById(R.id.textView);
    }

    public void bind(String text) {
        sessionItemView.setText(text);
    }

    static SessionViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new SessionViewHolder(view);
    }
}