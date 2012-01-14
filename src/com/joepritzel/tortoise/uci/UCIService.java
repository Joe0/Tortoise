package com.joepritzel.tortoise.uci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.joepritzel.ddd.Service;
import com.joepritzel.tortoise.io.IOWorkerService;
import com.joepritzel.tortoise.uci.message.UCIMessage;
import com.joepritzel.tortoise.uci.message.in.UCIDecodingService;

/**
 * This service deals with the interaction of the engine and external
 * applications through the UCI.
 * 
 * @author Joe Pritzel
 * 
 */
@Service
public class UCIService {

	/**
	 * The BufferedReader, which is used to read messages from external
	 * programs.
	 */
	private static BufferedReader input;

	/**
	 * Initializes the UCIService.
	 */
	public static void init() {
		input = new BufferedReader(new InputStreamReader(System.in));

		// Continually parses input.
		IOWorkerService.exec(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						send(UCIDecodingService.decode(input.readLine()));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		});
	}

	/**
	 * Handles then sending of messages.
	 * 
	 * @param message
	 *            - The message to send.
	 */
	private static void send(UCIMessage message) {
		System.out.println(message.toString());
	}
}
