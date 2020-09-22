package com.fengyue.bangcle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemCommand {

	private static String OS = System.getProperty("os.name").toLowerCase();

	public static void execute(String command) throws IOException, InterruptedException {
		Runtime runtime = Runtime.getRuntime();
		Process pr;
		System.out.println("execute " + command);

		if (isWindows()) {
			pr = runtime.exec("cmd /c "+command);
		}else{
			pr = runtime.exec(command);
		}


		BufferedReader input = new BufferedReader(new InputStreamReader(
				pr.getInputStream()));

		String line = null;

		while ((line = input.readLine()) != null) {
			System.out.println(line);
		}

		int exitVal = pr.waitFor();
		System.out.println("Exited with error code " + exitVal);
	}


    public static boolean isWindows() {
        return (OS.indexOf("win") >= 0);
    }

}
