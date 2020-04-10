package com.company.Tutorial1;

public class DPlan extends ISP {
    public DPlan(int mbpsSubscription, int dataSubcription) {
        super("DPlan");
        price = 10 * mbpsSubscription + 0.2 * dataSubcription;
    }
}
