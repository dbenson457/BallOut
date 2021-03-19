package uk.aston.ballout.data;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class SessionViewModel extends AndroidViewModel {

    private SessionRepository mRepository;

    private final LiveData<List<Session>> mAllSessions;

    public SessionViewModel (Application application) {
        super(application);
        mRepository = new SessionRepository(application);
        mAllSessions = mRepository.getAllSessions();
    }

    LiveData<List<Session>> getmAllSessions() { return mAllSessions; }

    public void insert(Session session) { mRepository.insert(session); }
}
