package uk.aston.ballout;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import uk.aston.ballout.data.Session;

public class SessionListAdapter extends ListAdapter<Session, SessionViewHolder> {

    public SessionListAdapter(@NonNull DiffUtil.ItemCallback<Session> diffCallback) {
        super(diffCallback);
    }

    @Override
    public SessionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return SessionViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(SessionViewHolder holder, int position) {
        Session current = getItem(position);
        holder.bind(current.getName());
    }

    static class SessionDiff extends DiffUtil.ItemCallback<Session> {

        @Override
        public boolean areItemsTheSame(@NonNull Session oldItem, @NonNull Session newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Session oldItem, @NonNull Session newItem) {
            return oldItem.getName().equals(newItem.getName());
        }
    }
}