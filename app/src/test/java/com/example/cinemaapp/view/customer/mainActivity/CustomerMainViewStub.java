package com.example.cinemaapp.view.customer.mainActivity;

public class CustomerMainViewStub implements CustomerMainView{

    private int bookTicketClicks,
                makeReviewClicks;

    private CustomerMainPresenter presenter;

    public CustomerMainPresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(CustomerMainPresenter presenter) {
        this.presenter = presenter;
    }

    public void onBookTicket() {
        bookTicketClicks++;
    }

    public void onMakeReview() {
        makeReviewClicks++;
    }

    public String getEmail() {
        return null;
    }

    public int getBookTicketClicks() {
        return bookTicketClicks;
    }

    public int getMakeReviewClicks() {
        return makeReviewClicks;
    }
}