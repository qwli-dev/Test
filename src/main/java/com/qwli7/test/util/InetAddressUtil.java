package com.qwli7.test.util;

import io.netty.util.internal.StringUtil;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.util.Enumeration;

public class InetAddressUtil {
    private InetAddressUtil() {
        super();
    }


    public static boolean checkPortOccupancy(int port) {
        String host = getIpAddress();

        boolean occupancy = false;
        if(StringUtil.isNullOrEmpty(host)) {
            return false;
        }
        try {
            final Socket socket = new Socket(getIpAddress(), port);
            occupancy = true;
        } catch (Exception ignored) {

        }

        return occupancy;
    }


    public static String getIpAddress() {
        try {
            final Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress inetAddress;

            while (networkInterfaces.hasMoreElements()) {
                final NetworkInterface networkInterface = networkInterfaces.nextElement();
                if (networkInterface.isLoopback() || networkInterface.isVirtual() || !networkInterface.isUp()) {
                    continue;
                }

                final Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    inetAddress = inetAddresses.nextElement();
                    if (inetAddress != null) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (Exception ignored) {}

        return "";
    }
}
