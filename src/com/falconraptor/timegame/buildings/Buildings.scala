package com.falconraptor.timegame.buildings

import com.falconraptor.timegame.buildings.energy._
import com.falconraptor.timegame.buildings.metal._
import com.falconraptor.timegame.buildings.water._

class Buildings {
  var bank: Bank = new Bank
  var quarry: Quarry = new Quarry
  var sawMill: SawMill = new SawMill
  var energy: Energy = new Energy
  var metal: Metal = new Metal
  var water: Water = new Water
}