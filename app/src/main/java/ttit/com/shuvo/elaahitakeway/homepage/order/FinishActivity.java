package ttit.com.shuvo.elaahitakeway.homepage.order;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import ttit.com.shuvo.elaahitakeway.R;

public class FinishActivity extends AppCompatActivity {

    public static TextView fin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        fin = findViewById(R.id.finish);
        fin.setText(PlaceOrderActivity.allData);
    }
}