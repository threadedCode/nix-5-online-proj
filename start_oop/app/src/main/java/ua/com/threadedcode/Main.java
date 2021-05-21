package ua.com.threadedcode;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        CommandLine cli = new CommandLine();

        try {
            cli.readConsole();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
