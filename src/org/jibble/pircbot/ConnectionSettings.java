package org.jibble.pircbot;

public class ConnectionSettings {
    public String server;
    public int port = 6667;
    public String password;
    public boolean useSSL = false;
    public boolean verifySSL = false;

    public ConnectionSettings(String server) {
        this.server = server;
    }
}
