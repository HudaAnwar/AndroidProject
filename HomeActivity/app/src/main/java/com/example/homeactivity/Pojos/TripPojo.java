package com.example.homeactivity.Pojos;

import java.util.ArrayList;
import java.util.List;

public class TripPojo {
    private String tripName;
    private String stPoint;
    private String endPoint;
    private List<String> tripNotes;
    //    private Date tripDate;
    //  private Time tripTime;
    private int tripStatus;
    private int tripType;
    private String ID;
    public TripPojo() {
        this.tripName = "";
        this.stPoint = "";
        this.endPoint = "";
        this.tripNotes = new ArrayList<>();
//        this.tripDate = new Date();
//        this.tripTime = new Time(0);
        this.tripStatus = 0;
        this.tripType = 0;
        this.ID = "";
    }

    public TripPojo(String tripName, String stPoint, String endPoint, List<String> tripNotes/*, Date tripDate, Time tripTime*/, int tripStatus, int tripType) {
        this.tripName = tripName;
        this.stPoint = stPoint;
        this.endPoint = endPoint;
        this.tripNotes = tripNotes;
//        this.tripDate = tripDate;
//        this.tripTime = tripTime;
        this.tripStatus = tripStatus;
        this.tripType = tripType;

    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String getStPoint() {
        return stPoint;
    }

    public void setStPoint(String stPoint) {
        this.stPoint = stPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public List<String> getTripNotes() {
        return tripNotes;
    }

    public void setTripNotes(List<String> tripNotes) {
        this.tripNotes = tripNotes;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
//    public Date getTripDate() {
//        return tripDate;
//    }
//
//    public void setTripDate(Date tripDate) {
//        this.tripDate = tripDate;
//    }
//
//    public Time getTripTime() {
//        return tripTime;
//    }
//
//    public void setTripTime(Time tripTime) {
//        this.tripTime = tripTime;
//    }

    public int getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(int tripStatus) {
        this.tripStatus = tripStatus;
    }

    public int getTripType() {
        return tripType;
    }

    public void setTripType(int tripType) {
        this.tripType = tripType;
    }
}
