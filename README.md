Assim que funciona o web service enviador de email:
	-Só funciona se o remetente for um "gmail", o destino não importa;
	-Sem cripitografia, apenas envio de e-mail;
	-Por ser de graça, pode demorar um pouco, pq o Heroku deixa a aplicação dormindo quando não está em uso.
	-Tem a opção ultilizando um e-mail padrão da própia API não tem muito segredo.
	-Este é o JSON ultilizado: 
{
  "usuario": {
    "email": "Endereço e-mail remetente",
    "senha": "Senha remetente"
  },
  "destinatario": "Endereço e-mail destinatário",
  "assunto": "Assunto",
  "corpo": "Corpo"
}
	-URL passando os dados completos: https://enviadoremail.herokuapp.com/api METODO: POST
	-URL usando e-mail da API: https://enviadoremail.herokuapp.com/api/usaremailpadrao METODO: POST
