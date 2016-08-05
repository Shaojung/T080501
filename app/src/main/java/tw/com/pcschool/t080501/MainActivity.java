package tw.com.pcschool.t080501;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StudentDAOImpl dao = new StudentDAOImpl(MainActivity.this);
        dao.addStudent(new Student("AA", "11", "11111"));
        dao.addStudent(new Student("BB", "22", "222"));
        dao.addStudent(new Student("CC", "33", "3333"));

        ArrayList<String> disp = new ArrayList<>();
        for (Student s :StudentDAOImpl.mylist)
        {
            disp.add(s.name);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                                MainActivity.this,
                                android.R.layout.simple_list_item_1,
                                disp
                                );
        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);



    }
}
