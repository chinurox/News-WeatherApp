package in.pradumn.newsweather_1.databases;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by Pradumn on 05-Jan-17.
 */
@Database(name = AppDatabase.NAME, version = AppDatabase.VERSION)
public class AppDatabase {
    public final static String NAME= "MyDatabase";
    public final static int VERSION=1;
}
