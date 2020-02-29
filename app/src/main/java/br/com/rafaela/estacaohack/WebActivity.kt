package br.com.rafaela.estacaohack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        //entra no site pelo javascript
        wbvSite.settings.javaScriptEnabled = true

        //entra no site pelo url descrito
        wbvSite.loadUrl("http://br.cellep.com/")
    }
}
