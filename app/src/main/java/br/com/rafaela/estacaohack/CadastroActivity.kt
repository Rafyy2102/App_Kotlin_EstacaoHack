package br.com.rafaela.estacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_main.*

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        /*Criando a Shared Preferences
        São necessários dois parâmentros dentro dos parenteses:
        1- Nome do arquivo que  será criado
        2- O modo de acesso dele
         */
        val minhaPreferencia = getSharedPreferences("minha-preferencia", Context.MODE_PRIVATE)

        //Criando o Editor do sharedPreferences
        val meuEditor = minhaPreferencia.edit()

        //Criando a Lista do spinner
        val listaSexo = arrayListOf("Selecione o sexo", "Feminino","Masculino")

        //Criando o Adaptador do spinner
        val adapterSexo = ArrayAdapter(
            this@CadastroActivity,
            android.R.layout.simple_spinner_dropdown_item,
            listaSexo
        )

        //Anexando o Adaptador no spinner

         spnSexo.adapter = adapterSexo

        /*
        Evento do clique do botão Cadastro
        Toda a execução depende do clique do botão
         */
        btnCadastro.setOnClickListener {
            //Recuperando os valores digitados pelo usário e armazenando em variaveis
            val nome = edtNome.text.toString().trim()
            val sobrenome = edtSobrenome.text.toString().trim()
            val email = edtEmail.text.toString().trim().toLowerCase()
            val senha = edtSenha.text.toString().trim()

            //Validando se todos os campos estão preenchidos e se o sexo foi selecionado
            if (nome.isEmpty() || sobrenome.isEmpty() || email.isEmpty() || senha.isEmpty()){
                //Imprimindo a mensagem de erro para o usuário no Toast
                Toast.makeText(
                    this@CadastroActivity,
                    "Preencha todos os campos!",
                    Toast.LENGTH_LONG
                ).show()
            }else if (spnSexo.selectedItem == "Selecione o sexo"){
                Toast.makeText(
                    this@CadastroActivity,
                    "Selecione o sexo!",
                    Toast.LENGTH_LONG
                ).show()
            }else{
                //Salvando as informações no Shared Preferences
                meuEditor.putString("nome", nome).apply()
                meuEditor.putString("sobrenome", sobrenome).apply()
                meuEditor.putString("email", email).apply()
                meuEditor.putString("senha", senha).apply()
                meuEditor.putString("sexo", spnSexo.selectedItem.toString()).apply()

                //imprimindo uma mensagem de cadastrado com sucesso para o usuário
                Toast.makeText(
                    this@CadastroActivity,
                    "Cadastrado com sucesso!",
                    Toast.LENGTH_LONG
                ).show()

                //Indo para a proxima tela
                startActivity(Intent(this@CadastroActivity, MainActivity::class.java))
            }

        }

    }
}
