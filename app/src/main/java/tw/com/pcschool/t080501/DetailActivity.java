package tw.com.pcschool.t080501;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent it = getIntent();
        int pos = it.getIntExtra("pos", 0);

        TextView tv = (TextView) findViewById(R.id.textView);
        EditText ed4 = (EditText) findViewById(R.id.editText4);
        EditText ed5 = (EditText) findViewById(R.id.editText5);

        Student s = StudentDAOImpl.mylist.get(pos);
        tv.setText(s.name);
        ed4.setText(s.addr);
        ed5.setText(s.tel);
    }
}
