package com.falconraptor.evolution.player

import java.awt.GridLayout
import javax.swing._

object Login extends JFrame("Login") {
  def setGUI() {
    setDefaultCloseOperation(WindowConstants DISPOSE_ON_CLOSE)
    val panel = new JPanel()
    panel.setLayout(new BoxLayout(panel, BoxLayout Y_AXIS))
    val userPass = new JPanel(new GridLayout(2, 2, 0, 0))
    val user = new JTextField("")
    val pass = new JPasswordField()
    userPass add new JLabel("Username:", SwingConstants CENTER)
    userPass add user
    userPass add new JLabel("Password:", SwingConstants CENTER)
    userPass add pass
    panel add userPass
    val submit = new JButton("Login")
    val create = new JButton("Create")
    val buttons = new JPanel(new GridLayout(1, 2, 0, 0))
    buttons add create
    buttons add submit
    panel add buttons
    setContentPane(panel)
    pack()
    setSize(250, getHeight)
    setLocationRelativeTo(null)
    setVisible(true)
    getRootPane setDefaultButton submit
  }
}
