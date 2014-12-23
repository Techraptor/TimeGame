package com.falconraptor.timegame.players;

import com.falconraptor.timegame.buildings.*;
import com.falconraptor.timegame.resources.*;

public class Player {
	public String username, password;
	public Buildings buildings = new Buildings();
	public Resources resources = new Resources();
	public Level level = new Level("1");
}
