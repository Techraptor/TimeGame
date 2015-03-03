package com.falconraptor.timegame.players

import com.falconraptor.timegame.buildings._
import com.falconraptor.timegame.research._
import com.falconraptor.timegame.resources._

class Player {
  var username: String = null
  var password: String = null
  var buildings: Buildings = new Buildings
  var resources: Resources = new Resources
  var research: Research = new Research
  var level: Level = new Level("1")
}