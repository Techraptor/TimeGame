package com.falconraptor.evolution

import java.net.URL
import javax.swing.JOptionPane

import com.falconraptor.evolution.player.Login
import com.falconraptor.utilities.Shutdown
import com.falconraptor.utilities.sql.SQL

object Evolution {

  def main(args: Array[String]) {
    //TODO init globals if needed
    checkForInternet()
    SQL getInstance() connect("jdbc:mysql://techraptor.us", "techrapt_evoluti", "EV0lut1on", SQL mysql)
    val shutdown = new Shutdown
    shutdown packagename = "Evolution"
    shutdown attachShutDownHook new Thread(new Runnable {
      override def run() = SQL getInstance() close()
    })
    //TODO create user login system
    Login setGUI()
    //TODO use both database and file... file for playing and database for multiplayer
    //TODO load user's data
    //TODO init user's data if any else create
    //TODO start threads if needed
  }

  def checkForInternet() {
    try {
      new URL("http://techraptor.us").openConnection.getInputStream
    } catch {
      case e: Exception =>
        JOptionPane showMessageDialog(null, "You need internet to play this game!", "No Internet", JOptionPane ERROR_MESSAGE)
        System exit 0
    }
  }
}
