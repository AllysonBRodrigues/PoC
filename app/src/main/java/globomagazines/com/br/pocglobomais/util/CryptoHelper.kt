package globomagazines.com.br.pocglobomais.util


import android.annotation.SuppressLint
import java.security.SecureRandom
import java.security.Security
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.spec.SecretKeySpec
import java.security.Security.addProvider
import java.security.spec.KeySpec
import javax.crypto.SecretKey
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec

import java.nio.charset.StandardCharsets
import javax.crypto.spec.IvParameterSpec
import android.R.attr.key
import java.io.UnsupportedEncodingException
import java.security.GeneralSecurityException
import javax.crypto.spec.PBEParameterSpec


/**
 * Created by AllysonRodrigues on 08/08/17.
 */

class CryptoHelper {



    companion object {
        val PBKDF2_DERIVATION_ALGORITHM = "PBKDF2WithHmacSHA1"
        private val KEY_LENGTH = 128
        // minimum values recommended by PKCS#5, increase as necessary
        private val ITERATION_COUNT = 1000
        private val PKCS5_SALT_LENGTH = 8
        private val random = SecureRandom()
        /**
         * Método para descriptografar o arquivos.
         * key: ByteArray da chave de criptografia
         * fileData: ByteArray do arquivo criptogradafo
         * Retorna o ByteArray do arquivo descriptografado
         */
        @Throws(Exception::class)
        fun decodeFile(key: SecretKey, fileData: ByteArray?): ByteArray? {
            val cipher = Cipher.getInstance("AES")
            cipher.init(Cipher.DECRYPT_MODE, key)
            return cipher.doFinal(fileData)
        }

        /**
         * Método para criptografar o arquivos.
         * key: ByteArray da chave de criptografia
         * fileData: ByteArray do arquivo a ser criptogradafo
         * Retorna o ByteArray do arquivo criptografado
         */
        @Throws(Exception::class)
        fun encodeFile(key: SecretKey, fileData: ByteArray?): ByteArray {
            val cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key)
            return cipher.doFinal(fileData)
        }

        /**
         * Método para gerar chave de criptografia
         * passaword: senha de geração da chave de criptografia
         * Retorna um ByteArray da chave de criptogradia
         */
        @Throws(Exception::class)
        fun generateKey(salt: ByteArray ,password: String): SecretKeySpec {
            val keySpec = PBEKeySpec(password.toCharArray(), salt,
                    ITERATION_COUNT, KEY_LENGTH)
            val keyFactory = SecretKeyFactory
                    .getInstance(PBKDF2_DERIVATION_ALGORITHM)
            val keyBytes = keyFactory.generateSecret(keySpec).encoded
            return SecretKeySpec(keyBytes, "AES")
        }

        fun generateSalt(): ByteArray {
            val b = ByteArray(PKCS5_SALT_LENGTH)
            random.nextBytes(b)
            return b
        }



    }




}
