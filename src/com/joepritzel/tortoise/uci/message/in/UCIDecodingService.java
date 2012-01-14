package com.joepritzel.tortoise.uci.message.in;

import com.joepritzel.ddd.Service;
import com.joepritzel.tortoise.uci.message.UCIMessage;

@Service
public class UCIDecodingService {

	public static UCIMessage decode(String line) {
		String[] args = line.split(" ");
		switch (args[0].toLowerCase()) {
		case "uci":
			return new UCI();
		case "debug":
			return new Debug(Boolean.parseBoolean(args[1]));
		case "isready":
			return new IsReady();
		default:
			return null;
		}
	}
}
