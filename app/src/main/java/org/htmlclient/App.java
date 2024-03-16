/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package org.htmlclient;

import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
        Html html = new Html();

        int numberOfThreads = 1000; // Number of threads to run in parallel

        IntStream.range(0, numberOfThreads)
                .parallel()
                .forEach(i -> {
                    // Call your class method here
                    html.sendRequest();
                });
    }
}