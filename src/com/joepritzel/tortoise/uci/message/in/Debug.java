package com.joepritzel.tortoise.uci.message.in;

import com.joepritzel.ddd.Value;
import com.joepritzel.tortoise.uci.message.UCIMessage;

@Value
public class Debug extends UCIMessage {

	private boolean on;

	protected Debug(boolean on) {
		this.on = on;
	}

	public boolean isOn() {
		return on;
	}

}
