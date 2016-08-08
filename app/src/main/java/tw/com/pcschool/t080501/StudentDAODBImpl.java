package tw.com.pcschool.t080501;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Student on 2016/8/8.
 */
public class StudentDAODBImpl implements StudentDAO {

    SQLiteDatabase db;

    public StudentDAODBImpl(Context context)
    {
        StudentDBHelper helper = new StudentDBHelper(context);
        db = helper.getWritableDatabase();
    }

    @Override
    public void addStudent(Student s) {
        ContentValues cv = new ContentValues();
        cv.put("name",  s.name);
        cv.put("addr", s.addr);
        cv.put("tel", s.tel);
// 執行SQL 語句
        long id = db.insert("student", null, cv);
    }

    @Override
    public void delStudent(Student s) {

    }

    @Override
    public void updateStudent(Student s) {

    }

    @Override
    public List getAllStudent() {
        ArrayList<Student> mylist = new ArrayList<>();

        Cursor c = db.rawQuery("Select * from student", null);
        if (c.moveToFirst())
        {
            do {
                Student t = new Student(c.getString(1), c.getString(2), c.getString(3));
                mylist.add(t);
            } while (c.moveToNext());
        }

        return mylist;
    }
}
