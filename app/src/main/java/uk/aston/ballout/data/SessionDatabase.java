package uk.aston.ballout.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Session.class}, version = 1, exportSchema = false)
public abstract class SessionDatabase extends RoomDatabase {
    public abstract SessionDao sessionDao();

    private static volatile SessionDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static SessionDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (SessionDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            SessionDatabase.class, "session_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                SessionDao dao = INSTANCE.sessionDao();
                dao.deleteAll();

                Session session = new Session(1,"Park1","Today","30");
                dao.insert(session);
                session = new Session(2,"Park2","Today","30");
                dao.insert(session);
                session = new Session(3,"Park3","Today","30");
                dao.insert(session);
                session = new Session(4,"Park4","Today","30");
                dao.insert(session);
            });
        }
    };
}

