package br.com.rafaela.estacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Criando o clique do botão Entrar
        btnEntrar.setOnClickListener {
            //Recuperando valores digitados
            val usuario = edtUsuario.text.toString().trim()
            val senha = edtSenhaLogin.text.toString().trim()

            //Abrindo o Shared Preference
            val minhaPreferencia = getSharedPreferences("minha-preferencia", Context.MODE_PRIVATE)

            //Compraração de dados com Shared Preferences
            val emailCorreto = minhaPreferencia.getString("email", "Rafaela")
            val senhaCorreto = minhaPreferencia.getString("senha", "1234")

            //Criando a condição para verificar se usuário e/ou senha estão vazios/corretos
            if(usuario.isEmpty()){
                //txvResultado.text = "Usuário vazio!"
                Toast.makeText(this@LoginActivity, "Usuário vazio!", Toast.LENGTH_SHORT).show()
            }else if(senha.isEmpty()){
                //txvResultado.text = "Senha vazia!"
                Toast.makeText(this@LoginActivity, "Senha vazia!", Toast.LENGTH_SHORT).show()
            }else if(usuario == emailCorreto){
                if(senha == senhaCorreto){
                    //txvResultado.text = "Usuário logado"
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                }else{
                    //txvResultado.text = "Senha incorreta!"
                    Toast.makeText(this@LoginActivity, "Senha incorreta!", Toast.LENGTH_SHORT).show()
                }
            }else{
                //txvResultado.text = "Usuário incorreto!"
                Toast.makeText(this@LoginActivity, "Usuário incorreto!", Toast.LENGTH_SHORT).show()
            }
        }

        //Criando a interação do botão cadastrar
        btnCadastrar.setOnClickListener {
            startActivity(Intent(this@LoginActivity, CadastroActivity::class.java))
        }

    }
}
