package com.example.homeactivity.Model;

import android.content.Context;

import com.example.homeactivity.Pojos.TripPojo;

import java.util.ArrayList;

public class MainContract {
    public interface IView {
        void renderUI(ArrayList<TripPojo> tripList);

        Context getCtx();

    }

    public interface IPresenter {
        void getData();
        void sendData(TripPojo tripPojo);
        void renderData(ArrayList<TripPojo> tripList);
        void deleteData(String ID);
    }

    public interface IModel {
        void getData();
        void sendData(TripPojo tripPojo);
        void deleteData(String ID);


    }
}
