package com.refactor.firstexample;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * 2016年3月8日
 * 
 * @author <a href = "wang.gaoliang@zte.com.cn">王高亮</a> 顾客类
 */
public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();
    public Customer(String name) {
        this.name = name;
    }
    public void addRental(Rental rental) {
        this.rentals.add(rental);
    }
    public String getName() {
        return this.name;
    }
    // 重构之前的函数
    public String statement() {
        double totalAmount = 0;// 局部变量
        int frequentRenterPoints = 0;// 局部变量
        // Enumeration rentals = this.rentals.e
        Iterator<Rental> it = rentals.iterator();
        String result = "Rental Record for" + getName() + "\n";
        while (it.hasNext()) {
            double thisAmount = 0;
            Rental each = (Rental) it.next();
            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2) {
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    if (each.getDaysRented() > 3) {
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    }
                    break;
            }
            frequentRenterPoints = each.getFrequentRenterPoints();
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
            result += "Amount owed is" + String.valueOf(totalAmount) + "\n";
            result += "You earned" + String.valueOf(getTotalFrequentRenterPoints())
                    + "frequent renter points";
        }
        return result;
    }
    // 重构之后的函数
    public String statement2() {
        Iterator<Rental> it = rentals.iterator();
        String result = "Rental Record for" + getName() + "\n";
        while (it.hasNext()) {
            Rental each = (Rental) it.next();
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge())
                    + "\n";
            result += "Amount owed is" + String.valueOf(getTotalCharge()) + "\n";
            result += "You earned" + String.valueOf(getTotalFrequentRenterPoints())
                    + "frequent renter points";
        }
        return result;
    }
    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Iterator<Rental> it = rentals.iterator();
        while (it.hasNext()) {
            Rental each = it.next();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
    private double getTotalCharge() {
        double result = 0;
        Iterator<Rental> it = rentals.iterator();
        while (it.hasNext()) {
            Rental each = it.next();
            result += each.getCharge();
        }
        return result;
    }
}
