package cloud.thecode.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.DatabaseMetaData;
import java.util.ArrayList;

/**
 * Created by Mazen on 1/18/2018.
 */



public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(Context context) {
        super(context, "Locations", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Places (id integer primary key autoincrement, latitude text, longitude text)");
        db.rawQuery("INSERT INTO Places (latitude, longitude) VALUES (22.2345678, 12.3456789)", null);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Places");
        onCreate(db);
    }


    public void insertPlace(Place p) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put("latitude", p.getLatitude());
        v.put("longitude", p.getLongitude());

        db.insertWithOnConflict("Places", null, v, 1);

    }

    public ArrayList<Place> getVisitedPlaces() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("Places", null, null, null, null, null, null);
        ArrayList<Place> points = new ArrayList<Place>();
        Place place;
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                place = new Place();
                place.setLongitude(cursor.getString(1));
                place.setLatitude(cursor.getString(2));
                points.add(place);
            }
        }
        cursor.close();
        db.close();
        return points;
    }



}
