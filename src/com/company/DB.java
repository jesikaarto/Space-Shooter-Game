package com.company;

public class DB {
    private int score;
    private String dateTime;
    private String gameuser;

    public DB(String gameuser,int score, String dateTime){

        this.score = score;
        this.gameuser = gameuser;
        this.dateTime = dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDateTime() {
        return dateTime;
    }
    public void setGameuser(String gameuser) {
        this.gameuser = gameuser;
    }
    public String getGameUser(){
        return gameuser;
    }



    public void setScore(int score) {

        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
