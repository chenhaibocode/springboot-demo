package com.chenhaibo.util;

/**
 * @Author: chenhaibo
 * @Description:
 * @Date: Created in 17:23 2018/7/26
 */
public class IPPaseInt {
    /**
     * ip转int
     */
    public static int ipToInteger(String ip) {
        String[] ips = ip.split("\\.");
        int ipFour = 0;
        for (String ip4 : ips) {
            Integer ip4a = Integer.parseInt(ip4);
            ipFour = (ipFour << 8) | ip4a;
        }
        return ipFour;
    }

    /**
     * int转ip
     */
    public static String intToIpString(Integer ip) {
        StringBuffer sb = new StringBuffer();
        for (int i = 3; i >= 0; i--) {
            int ipa = (ip >> (8 * i)) & (0xff);
            sb.append(ipa + ".");
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    public static void main(String[] args) {
        Integer ipInteger = IPPaseInt.ipToInteger("172.24.243.209");
        System.out.println(ipInteger);
        System.out.println(IPPaseInt.intToIpString(ipInteger));
    }
}
