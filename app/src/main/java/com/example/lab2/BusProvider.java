package com.example.lab2;

import com.squareup.otto.Bus;

public class BusProvider {
    private static final Bus BUS = new Bus();

    private BusProvider() {
    }

    public static Bus getInstance() {
        return BUS;
    }
}