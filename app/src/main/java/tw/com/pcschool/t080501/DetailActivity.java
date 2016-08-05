package tw.com.pcschool.t080501;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    TextView tv;
    EditText ed4, ed5;
    Student s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent it = getIntent();
        int pos = it.getIntExtra("pos", 0);

        tv = (TextView) findViewById(R.id.textView);
        ed4 = (EditText) findViewById(R.id.editText4);
        ed5 = (EditText) findViewById(R.id.editText5);

        s = StudentDAOImpl.mylist.get(pos);
        tv.setText(s.name);
        ed4.setText(s.addr);
        ed5.setText(s.tel);
    }

    public void click_update(View v)
    {
        StudentDAOImpl dao = new StudentDAOImpl(DetailActivity.this);
        Student s = new Student(tv.getText().toString(), ed4.getText().toString(), ed5.getText().toString());
        dao.updateStudent(s);
    }

    public void click_del(View v)
    {
        StudentDAOImpl dao = new StudentDAOImpl(DetailActivity.this);
        dao.delStudent(s);
        finish();
    }

}
