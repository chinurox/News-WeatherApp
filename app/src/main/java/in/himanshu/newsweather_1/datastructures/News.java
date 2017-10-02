package in.pradumn.newsweather_1.datastructures;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import in.pradumn.newsweather_1.databases.AppDatabase;

/**
 * Created by Pradumn on 28-Sep-16.
 */
@Table(database = AppDatabase.class)
public class News extends BaseModel{
    public String newsPosterPath;
    @Column
    @PrimaryKey
    public String headline;
    @Column
    public String story;
    @Column
    public String photoMemoryPath;

    public News() {

    }

    public News(String newsPosterPath,String headline) {
        this.headline= headline;
        this.newsPosterPath= newsPosterPath;
    }
}
