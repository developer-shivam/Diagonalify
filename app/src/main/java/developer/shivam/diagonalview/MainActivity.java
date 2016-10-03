package developer.shivam.diagonalview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import developer.shivam.library.DiagonalView;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DiagonalView diagonalView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Profile");
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        setSupportActionBar(toolbar);

        diagonalView = (DiagonalView) findViewById(R.id.diagonal_view);
        diagonalView.setAngle(15);
        diagonalView.setDiagonalGravity(DiagonalView.LEFT);
        diagonalView.setBackgroundColor(Color.WHITE);
    }
}
