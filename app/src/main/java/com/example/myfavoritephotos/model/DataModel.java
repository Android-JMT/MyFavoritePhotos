package com.example.myfavoritephotos.model;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Base64;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.myfavoritephotos.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;

public class DataModel {
    @SuppressLint("StaticFieldLeak")
    private static final DataModel instance = new DataModel();

    public static DataModel getInstance(){
        return instance;
    }

    private static ImageDatabase database;
    public static ArrayList<Image> images;
    private static Context context;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void setContext(Context context) {
        this.context = context;
        database = new ImageDatabase(context);
        images = database.retrieveImagesFromDb();
        Drawable drawable = context.getResources().getDrawable(R.drawable.dog);
        byte[] image = imageFileToByte(drawable);
        addImage(new Image("Scooby", image ));
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void addImage(Image image) {
        Integer id = database.createImageInDb(image);
        if (id > 0) {
            image.setId(id);
            images.add(image);
        } else {
            Toast.makeText(context, "Add image problem", Toast.LENGTH_LONG).show();
        }
    }

    public byte[] imageFileToByte(Drawable drawable){
        Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        return stream.toByteArray();
    }
}
