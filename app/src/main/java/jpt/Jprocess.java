package jpt;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Jprocess {
    public static void demoProcess() throws Exception {

        try {
            String[] command = {"date"};
            Process process = Runtime.getRuntime().exec(command);

            // process.getInputStream(); returns data from the launched processes stdout
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            System.out.println("Exited with code: " + exitCode); 
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    };

    public static void getCurrentProcessInfo() {
        ProcessHandle current = ProcessHandle.current();
        long pid = current.pid();
        ProcessHandle.Info info = current.info();

        System.out.println("PID: " + pid);
        info.command().ifPresent(cmd -> System.out.println("Command: " + cmd));
        info.arguments().ifPresent(args -> System.out.println("Arguments: " + String.join(" ", args)));
        info.startInstant().ifPresent(start -> System.out.println("Start Time: " + start));
        info.totalCpuDuration().ifPresent(cpu -> System.out.println("CPU Time: " + cpu));
        info.user().ifPresent(user -> System.out.println("User: " + user));
    }

}
