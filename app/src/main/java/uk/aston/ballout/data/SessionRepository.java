package uk.aston.ballout.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class SessionRepository {

    private SessionDao mSessionDao;
    private LiveData<List<Session>> mAllSessions;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    SessionRepository(Application application) {
        SessionDatabase db = SessionDatabase.getDatabase(application);
        mSessionDao = db.sessionDao();
        mAllSessions = (LiveData<List<Session>>) mSessionDao.getAll();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<Session>> getAllSessions() {
        return (LiveData<List<Session>>) mAllSessions;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(Session session) {
        SessionDatabase.databaseWriteExecutor.execute(() -> {
            mSessionDao.insert(session);
        });
    }
}