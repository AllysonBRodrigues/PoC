package globomagazines.com.br.pocglobomais.util

import android.os.AsyncTask
import android.util.Log
import globomagazines.com.br.pocglobomais.presentation.Internet.InternetPresentation
import java.net.InetAddress

/**
 * Created by AllysonRodrigues on 21/08/17.
 */

class CheckConnection(var ip: InternetPresentation) : AsyncTask<Void, Void, Boolean?>(){

    override fun doInBackground(vararg p0: Void?): Boolean? {
        var response = false
        try {
            val ipAdd = InetAddress.getByName("google.com")
            response = !ipAdd!!.equals("")
        }catch (e: Exception){
            Log.e("Erro", e.message)
        }finally {
            return response
        }
    }

    override fun onPostExecute(result: Boolean?) {
        if (result != null) {
            ip.responseConnection(result)
        }else{
            ip.responseConnection(false)
        }
    }


}