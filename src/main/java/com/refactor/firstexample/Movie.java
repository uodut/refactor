package com.refactor.firstexample;
/**
 * 2016年3月8日
 * 
 * @author <a href = "wang.gaoliang@zte.com.cn">王高亮</a> 电影
 */
public class Movie {
    /**
     * 儿童片
     */
    public static final int CHILDRENS = 2;
    /**
     * 普通片
     */
    public static final int REGULAR = 0;
    /**
     * 新片
     */
    public static final int NEW_RELEASE = 1;
    private String title;
    private int priceCode;
    private Price price;
    public Movie(String title, int priceCode) {
        this.title = title;
        // this.priceCode = priceCode;
        setPriceCode(priceCode);
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getPriceCode() {
        return this.price.getPriceCode();
    }
    public void setPriceCode(int priceCode) {
        // this.priceCode = priceCode;
        switch (priceCode) {
            case REGULAR:
                this.price = new RegularPrice();
                break;
            case CHILDRENS:
                this.price = new ChildrenPrice();
                break;
            case NEW_RELEASE:
                this.price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }
    double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }
    public int getFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
    }
}
