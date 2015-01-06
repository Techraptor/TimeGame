package com.falconraptor.timegame.resources;

import com.falconraptor.timegame.resources.fuel.*;
import com.falconraptor.timegame.resources.metals.*;
import com.falconraptor.timegame.resources.money.*;
import com.falconraptor.timegame.resources.ores.*;
import com.falconraptor.timegame.resources.utilities.*;

public class Resources {
	public Fuels fuels = new Fuels();
	public Metals metals = new Metals();
	public Money money = new Money();
	public Utilities utilities = new Utilities();
	public Crystals crystals = new Crystals("0");
	public Diamonds diamonds = new Diamonds("0");
	public Stone stone = new Stone("0");
	public Wood wood = new Wood("0");
	public Ores ores = new Ores();
}
