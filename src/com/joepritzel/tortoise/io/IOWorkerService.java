package com.joepritzel.tortoise.io;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.joepritzel.ddd.Service;
import com.joepritzel.tortoise.config.Config;

/**
 * This is the IO service, and should be used for all IO.
 * 
 * @author Joe Pritzel
 * 
 */
@Service
public class IOWorkerService {

	/**
	 * The ExecutorService that is the backbone of this service.
	 */
	private static final ExecutorService exec = Executors
			.newFixedThreadPool(Config.IOWorkerThreads);

	/**
	 * Executes the runnable on one of the IO threads.
	 * 
	 * @param r
	 *            - The runnable to execute.
	 */
	public static void exec(Runnable r) {
		exec.execute(r);
	}
}
