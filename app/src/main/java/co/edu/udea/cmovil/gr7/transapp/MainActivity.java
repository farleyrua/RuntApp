package co.edu.udea.cmovil.gr7.transapp;


import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.Camera;
//import android.graphics.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private static final int CAMERA_REQUEST = 1888;
    private android.hardware.Camera mCamera = null;
    private CameraView mCameraView = null;
    private Bitmap photo = null;
    private ImageView imageView;
    private Button btnConsult;
    private byte[] ba = null;
    private ByteArrayOutputStream bao = new ByteArrayOutputStream();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        btnConsult = (Button) findViewById(R.id.btnConsult);

        this.imageView = (ImageView)this.findViewById(R.id.imageView);

        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);

        btnConsult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String byteText = Arrays.toString(ba);
                enviarString(byteText);
                //Intent consultActivity = new Intent(this, ConsultActivity.class);
                //transfers the object as a bundle to the next activity
                //consultActivity.putExtra("Image", byteText);
                //startActivity(consultActivity);
                /*
                Toast msgBtn = Toast.makeText(getApplicationContext(), Arrays.toString(ba), Toast.LENGTH_SHORT);
                msgBtn.show();
                */

            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);

            //Intent consultActivity = new Intent(this,ConsultActivity.class);
            //transfers the object as a bundle to the next activity
            //consultActivity.putExtra("Image",photo);
            //startActivity(consultActivity);


            photo.compress(Bitmap.CompressFormat.JPEG, 100, bao);
            ba = bao.toByteArray();

        }
    }
    void enviarString(String texto){
        Intent consultActivity = new Intent(this, ConsultActivity.class);
        //transfers the object as a bundle to the next activity
        consultActivity.putExtra("Texto", texto);
        startActivity(consultActivity);
    }
}
