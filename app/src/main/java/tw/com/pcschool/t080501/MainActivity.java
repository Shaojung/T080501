package tw.com.pcschool.t080501;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StudentDAOImpl dao = new StudentDAOImpl(MainActivity.this);
        dao.addStudent(new Student("AA", "11", "11111"));
    }
}
