package globomagazines.com.br.pocglobomais.presentation.criptografia

import android.util.Log
import globomagazines.com.br.pocglobomais.presentation.Criptografia.CriptografiaPresentation
import globomagazines.com.br.pocglobomais.util.CryptoHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import javax.crypto.SecretKey

/**
 * Created by AllysonRodrigues on 10/08/17.
 */

class CriptografiaPresentationTest {


    @Test fun testeCriptografia(){

       val salt = CryptoHelper.generateSalt()
       var key: SecretKey = CryptoHelper.generateKey( salt , "password")
       val criptografiaPresentation = CriptografiaPresentation()

       val urlCriptografado = CriptografiaPresentationTest::class.java.classLoader.getResource("Criptografado.rtf")
       val arquivoCriptografado =  File(urlCriptografado.toURI())

       val byteArquivoCriptografado =   criptografiaPresentation.criptografarArquivo(arquivoCriptografado, key)
       val byteArquivoDescriptografado =   criptografiaPresentation.descriptografarArquivo(arquivoCriptografado, key)

        checkNotNull(byteArquivoCriptografado)
        checkNotNull(byteArquivoDescriptografado)

        Assert.assertArrayEquals(byteArquivoCriptografado,  criptografiaPresentation.criptografarArquivo(arquivoCriptografado, key))
        Assert.assertArrayEquals(byteArquivoDescriptografado,  criptografiaPresentation.descriptografarArquivo(arquivoCriptografado, key))

    }




}