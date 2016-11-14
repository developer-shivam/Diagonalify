package developer.shivam.diagonalview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import developer.shivam.library.DiagonalView;

public class MainActivity extends AppCompatActivity {

    DiagonalView diagonalView;
    ListView lvSampleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diagonalView = (DiagonalView) findViewById(R.id.diagonal_view);
    }
}
