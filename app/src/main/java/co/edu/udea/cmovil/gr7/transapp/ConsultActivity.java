package co.edu.udea.cmovil.gr7.transapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by S410P Touch on 11/11/2015.
 */
public class ConsultActivity extends Activity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consult_activity);

        textView = (TextView) findViewById(R.id.textView);
        String texto = (String) getIntent().getSerializableExtra("Texto");
        textView.setText(texto);

    }
}
