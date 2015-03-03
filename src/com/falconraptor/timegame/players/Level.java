package com.falconraptor.timegame.players;

import java.math.*;

public class Level extends BigInteger {
	public BigInteger xp, xpNeeded;

	public Level (String val) {
		super(val);
	}

	public BigInteger xpLeft () {
		return xpNeeded.subtract(xp);
	}
}
