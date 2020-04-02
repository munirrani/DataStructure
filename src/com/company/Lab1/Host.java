package com.company.Lab1;

public class Host {

    private String name, IPAddress, subnetMask;
    private boolean status;

    public Host(String name, String IPAddress, String subnetMask, boolean status) {
        this.name = name;
        this.IPAddress = IPAddress;
        this.subnetMask = subnetMask;
        this.status = status;

        if (status) {
            System.out.println("Host Name: " + name + " IP: " + IPAddress + " Subnet Mask: " + subnetMask + " Status: UP");
        } else {
            System.out.println("Host Name: " + name + " IP: " + IPAddress + " Subnet Mask: " + subnetMask + " Status: DOWN");
        }
    }

    public String getName() { return  name; };
    public String getIPAddress() { return IPAddress; };
    public String getSubnetMask() { return subnetMask; };
    public boolean getStatus() { return status; };
}
