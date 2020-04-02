package com.company.Tutorial1;

public class Tutorial1 {

    public Tutorial1 () {
        Q4();
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
