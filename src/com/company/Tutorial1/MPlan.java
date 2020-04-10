package com.company.Tutorial1;

public class MPlan extends ISP {
    public MPlan(int mbpsSubscription, int dataSubcription) {
        super("MPlan");
        price = 5 * mbpsSubscription + 0.8 * dataSubcription;
    }
}
