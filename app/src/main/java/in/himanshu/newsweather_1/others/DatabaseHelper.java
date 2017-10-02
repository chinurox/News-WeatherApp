package in.pradumn.newsweather_1.others;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Pradumn on 12-Oct-16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public final static String DATABASE_NAME="default_name";
    public final static String TOPSTORIES_TABLE_NAME="topstories_name";
    public final static String ID="id";
    public final static String HEADLINE= "headline";
    public final static String PUBLISH_DATE= "publish_date";
    public final static String WEBURL= "weburl";
    public final static String PHOTO_PATH= "photo_path";
    public final static String KEYWORDS= "keywords";
    public final static String STORY= "story";
    public final static String READ="read";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String topStoriesTable= "CREATE TABEL "+ TOPSTORIES_TABLE_NAME +
                                "(" + ID +" INTEGER," +
                                      HEADLINE +" TEXT," +
                                      PUBLISH_DATE+" TEXT," +
                                      WEBURL+" TEXT," +
                                      PHOTO_PATH+" TEXT," +
                                      KEYWORDS+" TEXT," +
                                      STORY+" TEXT," +
                                      READ+" TEXT" + ");";


        sqLiteDatabase.execSQL(topStoriesTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
