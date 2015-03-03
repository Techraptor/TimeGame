package com.falconraptor.timegame.references

import com.falconraptor.utilities.Shutdown
import com.falconraptor.utilities.logger._

object References {
  var console: Console = Logger.console
  var shutdown: Shutdown = new Shutdown
}