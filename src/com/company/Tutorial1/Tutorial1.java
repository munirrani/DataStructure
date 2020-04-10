package com.company.Tutorial1;

public class Tutorial1 {

    public Tutorial1 () {
        Q1();
        Q2();
        Q3();
        Q4();
    }

    private void Q1() {
        Tarikh tarikh = new Tarikh(5, 11 ,2016);
        System.out.println(tarikh.toString());
    }

    private void Q2() {
        Sentence sentence = new Sentence("How are you?");
        sentence.show();
    }

    private void Q3() {
        System.out.println("5Mbps Subscription and 50GB");
        DPlan dPlan = new DPlan(5, 50);
        dPlan.displayPlan();
        MPlan mPlan = new MPlan(5, 50);
        mPlan.displayPlan();
        if (dPlan.compareTo(mPlan) < 0) {
            System.out.println("DPlan is cheaper as compared to MPlan");
        } else if (dPlan.compareTo(mPlan) > 0) {
            System.out.println("DPlan is more expensive as compared to MPlan");
        } else {
            System.out.println("DPlan is the same as compared to MPlan");
        }
    }

    private void Q4() {
        SmartPhone[] smartPhones = {
                new SmartPhone("iPhone", 2400),
                new SmartPhone("Samsung", 2200),
                new SmartPhone("Nokia", 1400),
                new SmartPhone("LG", 1800)
        };

        System.out.println("List of Smart Phone");
        for (int i =0; i < smartPhones.length; i++) {
            System.out.print(smartPhones[i].toString());
        }
        System.out.println();

        SmartPhone tempPhone;
        for (int i = 0; i < smartPhones.length; i++) {
            for (int j = 0; j < smartPhones.length; j++) {
                tempPhone = smartPhones[j];
                if (smartPhones[j].compareTo(smartPhones[i]) > 0) {
                    smartPhones[j] = smartPhones[i];
                    smartPhones[i] = tempPhone;
                }
            }
        }

        System.out.println("List of SmartPhone in ascending");
        for (int i =0; i < smartPhones.length; i++) {
            System.out.print(smartPhones[i].toString());
        }
        System.out.println();
    }
}
