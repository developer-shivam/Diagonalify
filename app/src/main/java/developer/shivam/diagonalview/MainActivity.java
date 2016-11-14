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

        lvSampleList = (ListView) findViewById(R.id.lvSampleItems);
        String[] numbers = new String[100];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = String.valueOf(i + 1);
        }
        lvSampleList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, numbers));

        diagonalView = (DiagonalView) findViewById(R.id.diagonal_view);
    }
}
