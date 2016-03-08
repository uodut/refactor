package com.nubia.refactor.firstexample;
/**
 * 2016年3月8日
 * 
 * @author <a href = "wang.gaoliang@zte.com.cn">王高亮</a> 租赁类：表示一个顾客租了一部影片
 */
public class Rental {
    private Movie movie;
    private int daysRented;
    public Movie getMovie() {
        return movie;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    public int getDaysRented() {
        return daysRented;
    }
    public void setDaysRented(int daysRented) {
        this.daysRented = daysRented;
    }
    public double getCharge() {
        return movie.getCharge(daysRented);
    }
    public int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(daysRented);
    }
}
