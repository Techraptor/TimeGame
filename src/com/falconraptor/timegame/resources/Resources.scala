package com.falconraptor.timegame.resources

import com.falconraptor.timegame.resources.fuel._
import com.falconraptor.timegame.resources.metals._
import com.falconraptor.timegame.resources.money._
import com.falconraptor.timegame.resources.ores._
import com.falconraptor.timegame.resources.utilities._

class Resources {
  var fuels: Fuels = new Fuels
  var metals: Metals = new Metals
  var money: Money = new Money
  var utilities: Utilities = new Utilities
  var crystals: Crystals = new Crystals("0")
  var diamonds: Diamonds = new Diamonds("0")
  var stone: Stone = new Stone("0")
  var wood: Wood = new Wood("0")
  var ores: Ores = new Ores
}