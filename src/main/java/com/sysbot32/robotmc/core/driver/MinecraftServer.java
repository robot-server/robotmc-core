package com.sysbot32.robotmc.core.driver;

import org.apache.commons.exec.*;

import java.io.*;
import java.util.List;

public class MinecraftServer {
    private static final String MINECRAFT_DIR = "~/minecraft";
    private static final String JVM_HEAP_SIZE = "1024M";
    private static final String SERVER_JAR = "server.jar";
    private static final List<String> OPTIONS = List.of("nogui");


    private final CommandLine commandLine;
    private DefaultExecutor executor;
    private ByteArrayOutputStream out;
    private PrintWriter in;

    public MinecraftServer() {
        this.commandLine = CommandLine.parse(String.format("java -Xms%s -Xmx%s -jar %s %s", JVM_HEAP_SIZE, JVM_HEAP_SIZE, SERVER_JAR, String.join(" ", OPTIONS)));
    }

    public void start() {
        try {
            this.executor = new DefaultExecutor();
            this.out = new ByteArrayOutputStream();
            final PipedOutputStream pout = new PipedOutputStream();
            final PipedInputStream pin = new PipedInputStream(pout);
            this.executor.setStreamHandler(new PumpStreamHandler(this.out, this.out, pin));
            this.executor.setWorkingDirectory(new File(MINECRAFT_DIR));
            this.in = new PrintWriter(pout);

            this.executor.execute(this.commandLine, new DefaultExecuteResultHandler());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        this.in.close();

        final ExecuteWatchdog watchdog = new ExecuteWatchdog(5000);
        this.executor.setWatchdog(watchdog);
        watchdog.destroyProcess();
    }

    public String read() {
        if (this.out.size() > 0) {
            final String output = this.out.toString();
            this.out.reset();
            return output;
        }
        return null;
    }

    public void write(final String input) {
        this.in.println(input);
    }
}
