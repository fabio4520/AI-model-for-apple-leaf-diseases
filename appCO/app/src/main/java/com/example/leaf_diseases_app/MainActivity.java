package com.example.leaf_diseases_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView image;
    Button btnPredict,btnCargarImagen, btnConocerMas;
    EditText etResult;

    private final String CARPETA_RAIZ = "misImagenes/";//ruta donde se va a almacenar la foto
    private final String RUTA_IMAGEN = CARPETA_RAIZ+ "misFotos"; //me permite cargar la imagen directamente desde el celular
    String path="";
    final int COD_SELECCIONA = 10;//codigo para que identifique cargar la imagen desde la galeria


    //Model
    private int mInputSize = 224; //size of the image
    private String mModelPath = "converted_model.tflite";
    private String mLabelPath = "label.txt";
    private  Classifier classifier;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = findViewById(R.id.imagenId);
        etResult = findViewById(R.id.etResult);
        btnCargarImagen = findViewById(R.id.btncargarImagen);
        btnCargarImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/"); //Intent del tipo imagen
                startActivityForResult(intent.createChooser(intent, "Seleccione la aplicación"),COD_SELECCIONA);//selecciona la app para seleccionar la imagen
            }
        });
        btnPredict = findViewById(R.id.btnPredict);
        btnPredict.setOnClickListener(v -> {
            Bitmap bitmap = ((BitmapDrawable)(image).getDrawable()).getBitmap();

            List<Classifier.Recognition> result = classifier.recognizeImage(bitmap);
            etResult.setText(result.get(0).toString());
        });
        btnConocerMas = findViewById(R.id.btnConocerMas);
        btnConocerMas.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Diseases.class);
            startActivity(intent);
        });

        //Model
        try {
            initClassifier();
            initViews();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Si seleccionamos una imagen, entonces:
        if (resultCode==RESULT_OK){

            switch (requestCode){
                case COD_SELECCIONA:
                    Uri mipath =data.getData();//Clase Uri, creamos un objeto llamado mipath = al dato que llega de la imagen seleccionada
                    image.setImageURI(mipath); // a la imagen le agregamos ese path
                    break;
            }
        }
    }

    private void initClassifier() throws IOException {
        classifier = new Classifier(getAssets(), mModelPath, mLabelPath, mInputSize);
    }

    private void initViews() {
        findViewById(R.id.imagenId).setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Bitmap bitmap = ((BitmapDrawable)((ImageView)v).getDrawable()).getBitmap();

        List<Classifier.Recognition> result = classifier.recognizeImage(bitmap);
        etResult.setText(result.get(0).toString());
        Toast.makeText(this, result.get(0).toString(), Toast.LENGTH_SHORT).show() ;
    }


    // La acplicación consume mucha memoria, hay que limpiar la cache
    public static void deleteCache(Context context) {
        try {
            File dir = context.getCacheDir();
            deleteDir(dir);
        } catch (Exception e) { e.printStackTrace();}
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
            return dir.delete();
        } else if(dir!= null && dir.isFile()) {
            return dir.delete();
        } else {
            return false;
        }
    }
}
