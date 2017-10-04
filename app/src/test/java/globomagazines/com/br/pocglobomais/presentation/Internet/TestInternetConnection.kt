package globomagazines.com.br.pocglobomais.presentation.Internet

import globomagazines.com.br.pocglobomais.util.CheckConnection
import org.junit.Test
import org.mockito.Mock



/**
 * Created by AllysonRodrigues on 18/08/17.
 */
class TestInternetConnection {

    @Mock
    var ip : InternetPresentation = InternetPresentation()

    //Internet ativada

    @Test fun testInternetConnectionSucess(){
        var inter = CheckConnection(ip)
    }

    //Internet desativada
    @Test fun testInternetConnectionErro(){
        var inter = InternetPresentation()

    }
}