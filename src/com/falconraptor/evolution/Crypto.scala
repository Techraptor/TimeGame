package com.falconraptor.evolution

import java.security.Key
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec
import javax.xml.bind.DatatypeConverter

object Crypto {
  val AES = "AES"
  val BYTE_FORMATTING = "UTF-8"
  private val key = "Ev0lut1onTechRap"

  def encrypt(decrypted: String): String = toHex(encrypt(getAESCipher, getAESKey, decrypted))

  def toHex(array: Array[Byte]) = DatatypeConverter.printHexBinary(array)

  def encrypt(cipher: Cipher, key: Key, decrypted: String): Array[Byte] = {
    cipher.init(Cipher.ENCRYPT_MODE, key)
    cipher.doFinal(decrypted.getBytes(BYTE_FORMATTING))
  }

  def decrypt(encrypted: Array[Byte]): String = decrypt(getAESCipher, getAESKey, encrypted)

  def getAESKey = new SecretKeySpec(key.getBytes(BYTE_FORMATTING), AES)

  def getAESCipher = Cipher.getInstance(AES)

  def decrypt(cipher: Cipher, key: Key, encrypted: Array[Byte]): String = {
    cipher.init(Cipher.DECRYPT_MODE, key)
    cipher.doFinal(encrypted).toString
  }
}
