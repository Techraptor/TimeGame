package com.falconraptor.timegame;

import com.falconraptor.timegame.references.*;
import com.falconraptor.utilities.logger.*;

public final class Timegame {
	public Timegame () {
		System.exit(0);
	}

	public static void main (String[] args) {
		for (String s : args) {
			try {
				Logger.level = Integer.parseInt(s);
			} catch (NumberFormatException ignored) {
				if ("console".equals(s.toLowerCase())) References$.console().setVisible(true);
				else References$.console().dispose();
			}
		}
		References$.shutdown().attachShutDownHook();
		new Timegame();
	}
}
