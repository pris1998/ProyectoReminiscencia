package com.example.proyectofct2.controlador;

public interface FirestoreControllerCallback {

        void onQueryComplete(boolean success);

        void onQueryFailure(Exception exception);


}
