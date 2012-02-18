package org.jibble.pircbot;

import java.io.*;
import org.apache.commons.configuration.*;

public abstract class ConfigurablePircBot extends PircBot {

    public void initBot(File file) throws Exception {
        initBot(new PropertiesConfiguration(file));
    }

    public void initBot(String fileName) throws Exception {
        initBot(new PropertiesConfiguration(fileName));
    }

    public void initBot(Configuration c) throws Exception {
        if (c.containsKey("Verbose")) {
            setVerbose(c.getBoolean("Verbose"));
        }

        if (c.containsKey("Nick")) {
            setName(c.getString("Nick"));
        }

        if (c.containsKey("UserName")) {
            setUserName(c.getString("UserName"));
        }

        if (c.containsKey("RealName")) {
            setRealName(c.getString("RealName"));
        }

        if (c.containsKey("Version")) {
            setVersion(c.getString("Version"));
        }

        if (c.containsKey("Finger")) {
            setFinger(c.getString("Finger"));
        }

        if (c.containsKey("Server")) {
            ConnectionSettings cs = new ConnectionSettings(c.getString("Server"));

            if (c.containsKey("Port")) {
                cs.port = c.getInt("Port");
            }

            if (c.containsKey("Password")) {
                cs.password = c.getString("Password");
            }

            if (c.containsKey("SSL")) {
                cs.useSSL = c.getBoolean("SSL");
            }

            if (c.containsKey("VerifySSL")) {
                cs.verifySSL = c.getBoolean("VerifySSL");
            }

            connect(cs);

            if (c.containsKey("Channels")) {
                joinChannel(c.getString("Channels"));
            }
        }
    }
}
