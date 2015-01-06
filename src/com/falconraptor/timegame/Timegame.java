package com.falconraptor.timegame;

import com.falconraptor.timegame.references.*;
import com.falconraptor.utilities.logger.*;

public class Timegame {
	public Timegame () {
	}

	public static void main (String... args) {
		for (String s : args) {
			try {
				Logger.level = Integer.parseInt(s);
			} catch (Exception e) {
				if (s.toLowerCase().equals("console")) References.console.setVisible(true);
				else References.console.dispose();
			}
		}
		References.shutdown.attachShutDownHook();
		new Timegame();
	}
}
