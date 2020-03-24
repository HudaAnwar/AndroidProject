package com.example.homeactivity.Model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.example.homeactivity.Pojos.TripPojo;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class MainModel implements MainContract.IModel {
    private ArrayList<TripPojo> tripList = new ArrayList<>();
    private MainContract.IPresenter presenter;
    private Context ctx;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference("Trips");
    private TripPojo tripPojo;
    
    public MainModel(MainContract.IPresenter pres, Context c){
         presenter=pres;
         ctx = c;
     }
    @Override
    public void getData(){
        // Obtain the FirebaseAnalytics instance.
        if (isConnectedToInternet()) {
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    tripList.clear();
                    for (DataSnapshot snap : dataSnapshot.getChildren()) {

                        TripPojo value = dataSnapshot.getValue(TripPojo.class);
                        tripList.add(snap.getValue(TripPojo.class));
                    }

                    presenter.renderData(tripList);

                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Log.w("TAG", "Failed to read value.", error.toException());
                }
            });
        }else{

        }
    }
    @Override
    public void sendData(TripPojo tripPojo) {
//        database = FirebaseDatabase.getInstance();
        if (isConnectedToInternet()) {
            String ID = myRef.push().getKey();
            tripPojo.setID(ID);
            myRef.child(ID).setValue(tripPojo);
        }else{

        }
    }

    @Override
    public void deleteData(String ID) {
        if(isConnectedToInternet()) {
            Query q = myRef.child(ID);
//        Query q = myRef.orderByChild("id").equalTo(ID);
            q.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        snapshot.getRef().removeValue();
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.e("TAG", "onCancelled", databaseError.toException());
                }
            });
        }else{

        }
    }
    public boolean isConnectedToInternet(){
        ConnectivityManager connectivity = (ConnectivityManager)ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null)
        {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED)
                    {
                        return true;
                    }

        }
        return false;
    }
}
