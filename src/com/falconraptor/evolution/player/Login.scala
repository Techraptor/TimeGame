package com.falconraptor.evolution.player

import java.awt.GridLayout
import java.awt.event.{ActionEvent, ActionListener}
import javax.swing._

import com.falconraptor.evolution.Crypto
import com.falconraptor.utilities.sql.SQL

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
    val buttons = new JPanel(new GridLayout(1, 1, 0, 0))
    submit addActionListener new ActionListener {
      override def actionPerformed(e: ActionEvent) {
        val stmt = SQL getInstance() getStatement
        var id = -1
        val p = Crypto.encrypt(new String(pass.getPassword))
        try {
          val rs = stmt executeQuery "SELECT * FROM techrapt_evolution.Users WHERE Username='" + user.getText + "' " + "AND Password='" + p + "'"
          rs next()
          id = rs getInt "ID"
          rs close()
        } catch {
          case e: Exception =>
            //e printStackTrace()
            try {
              stmt executeUpdate "INSERT INTO techrapt_evolution.Users (ID,Username,Password) VALUES (NULL,'" + user.getText + "','" + p + "')"
              val rs = stmt executeQuery "SELECT * FROM techrapt_evolution.Users WHERE Username='" + user.getText + "' AND Password='" + p + "'"
              rs next()
              id = rs getInt "ID"
              rs close()
            } catch {
              case e: Exception =>
                e printStackTrace()
                id = -1
            }
        }
        stmt close()
        if (id == -1) {
          JOptionPane showMessageDialog(null, "An error has occurred, Closing!", "Error", JOptionPane ERROR_MESSAGE)
          System exit 0
        }
      }
    }
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
