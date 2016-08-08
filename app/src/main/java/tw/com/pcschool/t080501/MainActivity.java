package tw.com.pcschool.t080501;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> disp = new ArrayList<>();
    ListView lv;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        StudentDAO dao = new StudentDAODBImpl(MainActivity.this);
        /*
        dao.addStudent(new Student("AA", "11", "11111"));
        dao.addStudent(new Student("BB", "22", "222"));
        dao.addStudent(new Student("CC", "33", "3333"));
*/
        List<Student> mylist = dao.getAllStudent();
        for (Student s : mylist)
        {
            disp.add(s.name);
        }
        adapter = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                disp
        );
        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(MainActivity.this, DetailActivity.class);
                it.putExtra("pos", position);
                startActivity(it);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        StudentDAO dao = new StudentDAODBImpl(MainActivity.this);
        List<Student> mylist = dao.getAllStudent();
        disp.clear();
        for (Student s :mylist)
        {
            disp.add(s.name);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_add)
        {
            Intent it = new Intent(MainActivity.this, AddActivity.class);
            startActivity(it);
        }
        return super.onOptionsItemSelected(item);
    }
}
