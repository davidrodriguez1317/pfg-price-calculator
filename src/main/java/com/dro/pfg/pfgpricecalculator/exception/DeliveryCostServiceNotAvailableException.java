package com.dro.pfg.pfgpricecalculator.exception;

public class DeliveryCostServiceNotAvailableException extends RuntimeException {

    public DeliveryCostServiceNotAvailableException() {
        super("Deliver cost service is not available");
    }
}
