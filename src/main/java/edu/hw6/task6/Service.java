package edu.hw6.task6;

public enum Service {
    FTP(21, "FTP (File Transfer Protocol)"),
    SSH(22, "SSH (Secure Shell)"),
    SMTP(25, "SMTP (Simple Mail Transfer Protocol)"),
    DNS(53, "DNS (Domain Name System)"),
    HTTP(80, "HTTP (HyperText Transfer Protocol)"),
    HTTPS(443, "HTTPS (HyperText Transfer Protocol Secure)"),
    ORACLE_DATABASE(1521, "Oracle Database"),
    MYSQL_DATABASE(3306, "MySQL Database"),
    RDP(3389, "Remote Desktop Protocol (RDP)"),
    POSTGRESQL_DATABASE(5432, "PostgreSQL Database"),
    MONGODB_DATABASE(27017, "MongoDB Database"),
    MDNS(5353, "mDNS (Multicast Domain Name System)"),
    LLMNR(5355, "LLMNR (Link-Local Multicast Name Resolution)"),
    AMQP(5672, "AMQP (Advanced Message Queuing Protocol)"),
    TELNET(23, "Telnet"),
    POP3(110, "POP3 (Post Office Protocol version 3)"),
    IMAP(143, "IMAP (Internet Message Access Protocol)"),
    DHCP(68, "DHCP (Dynamic Host Configuration Protocol)"),
    MICROSOFT_DS(445, "Microsoft-DS Active Directory"),
    ADOBE_FLASH(843, "Adobe Flash"),
    SSDP(1900, "SSDP (Simple Service Discovery Protocol)"),
    EPMAP(135, "EPMAP (End Point Mapper)"),
    NETBIOS_NAME(137, "NetBIOS Name Service"),
    NETBIOS_DATAGRAM(138, "NetBIOS Datagram Service"),
    NETBIOS_SESSION(139, "NetBIOS Session Service"),
    WS_DISCOVERY(3702, "WS-Discovery (Web Services Dynamic Discovery)"),
    DROPBOX(17500, "Dropbox"),
    NTP(123, "NTP (Network Time Protocol)"),
    SNMP(162, "SNMP (Simple Network Management Protocol)"),
    IKE(500, "IKE (Internet Key Exchange)");

    private final int port;
    private final String serviceName;

    Service(int port, String serviceName) {
        this.port = port;
        this.serviceName = serviceName;
    }

    public static String getServiceByPort(int port) {
        for (Service service : values()) {
            if (service.port == port) {
                return service.serviceName;
            }
        }
        return "";
    }
}
