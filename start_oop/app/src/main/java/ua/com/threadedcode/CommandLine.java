package ua.com.threadedcode;

import ua.com.threadedcode.todo.Todo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandLine {
    private Todo todo = new Todo();

    static {
        System.out.println("Synopsis: \n" +
                "0: exit, 1: add task, 2: show tasks");
    }

    public String[] getArgs(String str){
        return str.split(",");
    }

    public void readConsole() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        String[] arg;
        while ((input = reader.readLine()) != null) {
            switch (input) {
                case "0": {
                    System.exit(0);
                }

                case "1": {
                    System.out.println("enter task title and description, separates it by comma ");
                    input= reader.readLine();
                    arg=getArgs(input);
                    todo.addTask(arg[0],arg[1]);
                    System.out.println("0: exit, 1: add task, 2: show tasks");
                    readConsole();
                }

                case "2": {
                    todo.readTask();
                    readConsole();
                    System.out.println("0: exit, 1: add task, 2: show tasks");
                }

            }
        }
    }
}
