package com.kensoftph.javafxapi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;

public class HelloController {
    @FXML
    private ImageView imageView;

    @FXML
    private void btn(ActionEvent event){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://dog.ceo/api/breeds/image/random")
                .build();

        try(Response response = client.newCall(request).execute()){
            String body = response.body().string();

            System.out.println(body);

            JSONObject jsonObject = new JSONObject(body);
            String imageURL = jsonObject.getString("message");

            Image image = new Image(imageURL);
            imageView.setImage(image);
            imageView.setFitWidth(image.getWidth());
            imageView.setFitHeight(image.getWidth());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}