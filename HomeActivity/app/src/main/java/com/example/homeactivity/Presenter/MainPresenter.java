package com.example.homeactivity.Presenter;

import android.content.Context;

import com.example.homeactivity.Model.MainContract;
import com.example.homeactivity.Model.MainModel;
import com.example.homeactivity.Pojos.TripPojo;

import java.util.ArrayList;

public class MainPresenter implements MainContract.IPresenter {
   MainContract.IView iView;
   MainContract.IModel iModel;

   public MainPresenter(MainContract.IView iView) {
      this.iView = iView;
      iModel = new MainModel(this,iView.getCtx());
   }

   @Override
   public void getData(){

      iModel.getData();
   }

   @Override
   public void sendData(TripPojo tripPojo) {
          iModel.sendData(tripPojo);
   }

   @Override
   public void renderData(ArrayList<TripPojo> tripList) {
      iView.renderUI(tripList);
   }

   @Override
   public void deleteData(String ID) {
      iModel.deleteData(ID);
   }
}
