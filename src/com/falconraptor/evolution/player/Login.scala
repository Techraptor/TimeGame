package com.falconraptor.evolution.player

import java.awt.GridLayout
import java.awt.event.{ActionEvent, ActionListener}
import java.security.MessageDigest
import javax.swing._
import javax.xml.bind.DatatypeConverter

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
        /*
        OLD CODE - HASH != ENCRYPTION
        val p = DatatypeConverter.printHexBinary(MessageDigest.getInstance("SHA-256").digest(pass.getPassword.toString.getBytes("UTF-8")))
        */
        /*
        NEW CODE - Probably broken
        val p = GameCryptology.toHexString(
        			GameCryptology.getInstance().encrypt(
        				GameCryptology.getAesCipher(),
        				pass.getPassword.toString().getBytes()
    				)
    			);
        */
        /*
        MODERNMAK CODE - Needs to be in new file
		        
		import java.util.*;
		import java.io.*;
		import java.util.Formatter;
		import java.security.Key;
		import java.security.NoSuchAlgorithmException;
		import javax.crypto.Cipher;
		import javax.crypto.spec.SecretKeySpec;
		import javax.xml.bind.DatatypeConverter;
		
		class GameCryptology {
		    private GameCryptology() {
		        this("ABCDEFGHIJKLMNOP");
		        //16 charachters long (A-Z,0-9), 128 bits
		    }
		
		    private GameCryptology(String key) {
		        myKey = key;
		    }
		
		    private String
		            myKey;
		    public static final String
		            AES_ENCRYPTION = "AES",
		            BYTE_FORMATTING = "UTF-8";//128 bits
		
		    public Key getAesKey()  {
		        return new SecretKeySpec(myKey.getBytes(), AES_ENCRYPTION);
		    }
		
		    public static Cipher getAesCipher() throws NoSuchAlgorithmException {
		    	try{
		        	return Cipher.getInstance(AES_ENCRYPTION);
		    	}
		    	catch(Exception e){
		    		System.out.println("Cipher not found!");
		    		return null;
		    	}
		    }
		
		    public static String toHexString(byte[] array) {
		        return DatatypeConverter.printHexBinary(array);
		    }
		
		    public static byte[] toByteArray(String s) {
		        return DatatypeConverter.parseHexBinary(s);
		    }
		
		    public byte[] encrypt(Cipher cipher, String decrypted) {
		    	return encrypt(cipher,this.getAesKey(),decrypted);
		    }
		    public static byte[] encrypt(Cipher cipher, Key key, String decrypted) {
		        try {
		            cipher.init(Cipher.ENCRYPT_MODE, key);
		            return cipher.doFinal(decrypted.getBytes(BYTE_FORMATTING));
		        } catch (Exception e) {
		            //Do whatever you want with the excetption;
		            return new byte[0];
		        }
		    }
		
		    public String decrypt(Cipher cipher, byte[] encrypted) {
		        return decrypt(cipher, this.getAesKey(),encrypted);
		    }
		    public static String decrypt(Cipher cipher, Key key, byte[] encrypted) {
		        try {
		            cipher.init(Cipher.DECRYPT_MODE, key);
		            return new String(cipher.doFinal(encrypted));
		        } catch (Exception e) {
		            //Do whatever you want with the excetption;
		            return new String("");
		        }
		    }
		
		    private static GameCryptology myGameCryptology;
		
		    //Note to falconRaptor; singleton instantiate requires locking for threading.
		    public static GameCryptology getInstance(String key) {
		        //Lock aroung this
		        if (myGameCryptology == null) {
		            myGameCryptology = new GameCryptology(key);
		        }
		        //End locking
		        return myGameCryptology;
		    }
		
		    public static GameCryptology getInstance() {
		        //Lock aroung this
		        if (myGameCryptology == null) {
		            myGameCryptology = new GameCryptology();
		        }
		        //End locking
		        return myGameCryptology;
		    }
		
		
		    public static void main(String[] args) throws java.lang.Exception {
				Scanner in = new Scanner(System.in);
		
		        String
		                password = new String("!"),
		                encryptedHex = new String("!!"),
		                decrypted = new String("!!!");
		
				password = in.nextLine();
		
		        GameCryptology crypt = GameCryptology.getInstance();
				Cipher cipher = GameCryptology.getAesCipher();
		
		
		        byte[] encrypted = crypt.encrypt(cipher,password);
		
		        encryptedHex = crypt.toHexString(encrypted);
		
		        decrypted = crypt.decrypt(cipher,encrypted);
		
		        System.out.println("Password : " + password);
		        System.out.println("Encrypted : " + encryptedHex);
		        System.out.println("Decrypted : " + decrypted);
		    }
		}

        */
        try {
          val rs = stmt executeQuery "SELECT * FROM techrapt_evolution.Users WHERE Username='" + user.getText + "' " +
            "AND Password='" + p + "'"
          rs next()
          id = rs getInt "ID"
          rs close()
        } catch {
          case e: Exception =>
            e printStackTrace()
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
