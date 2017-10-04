package globomagazines.com.br.pocglobomais.presentation.Internet


import globomagazines.com.br.pocglobomais.util.CheckConnection

/**
 * Created by AllysonRodrigues on 18/08/17.
 */

class InternetPresentation: InternetContract.Presentation{

    var view: InternetContract.View? = null

    override fun bind(view: InternetContract.View) {
        this.view = view
    }

    override fun responseConnection(retorno: Boolean){
        view?.exibirStatus(retorno)
    }


    override fun checkConnection(){
        val cc = CheckConnection(this)
        cc.execute()
    }


}
