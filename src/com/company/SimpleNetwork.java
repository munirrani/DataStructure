package com.company;

public class SimpleNetwork {

    /*
    Create a class SimpleNetwork to simulate ping command. The class consists of the name,
    IP address, subnet mask and status (on/off) of a host. The host can only ping each other
    if the hosts are from the same network. The host is from same network if the (host IP address
    AND host Subnet Mask) is equal to (destination IP address AND host Subnet Mask). Create a Tester
    class to test the program, given output below.
     */

    public SimpleNetwork() {
        Host host1 = new Host("Host 1", "10.1.1.1", "255.255.255.224", true);
        Host host2 = new Host("Host 2", "10.1.1.2", "255.255.255.224", false);
        Host host3 = new Host("Host 3", "10.1.1.70", "255.255.255.224", true);
        Host host4 = new Host("Host 4", "10.1.1.15", "255.255.255.224", true);

        tryPing(host1, host2);
        tryPing(host1, host3);
        tryPing(host1, host4);
    }

    private boolean tryPing(Host source, Host destination) {
        if (!destination.getStatus()) {
            System.out.println(source.getName() + " cannot ping " + destination.getName() +
                    " because the destination " + destination.getName() + " is down.");
            return false;
        }

        if (!sameNetwork(source, destination)){
            System.out.println(source.getName() + " cannot ping " + destination.getName() +
                    " because the destination " + destination.getName() + " is located in different network.");
            return false;
        }
        System.out.println(source.getName() + " can ping " + destination.getName());
        return  true;
    }

    private boolean sameNetwork(Host network1, Host network2) {
        String[] IPAddress1 = network1.getIPAddress().split("\\.");
        String[] subnetMask1 = network1.getSubnetMask().split("\\.");

        String[] IPAddress2 = network2.getIPAddress().split("\\.");
        String[] subnetMask2 = network2.getSubnetMask().split("\\.");

        String networkAddress1 = "";
        String networkAddress2 = "";
        for (int i = 0; i < 4; i++) {
            networkAddress1 = networkAddress1.concat(String.valueOf(
                    Integer.valueOf(IPAddress1[i]) & Integer.valueOf(subnetMask1[i])
            ));
            if (i != 3) networkAddress1 = networkAddress1.concat(".");
            networkAddress2 = networkAddress2.concat(String.valueOf(
                    Integer.valueOf(IPAddress2[i]) & Integer.valueOf(subnetMask2[i])
            ));
            if (i != 3) networkAddress2 = networkAddress2.concat(".");
        }
        //System.out.println(networkAddress1 + " " + networkAddress2);
        if (networkAddress1.compareTo(networkAddress2) == 0) return true;
        return false;
    }
}
