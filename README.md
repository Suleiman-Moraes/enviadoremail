# enviadoremail
Um serviço online para enviar e-mail

Assim que funciona o web service enviador de email:
	<br/>-Só funciona se o remetente for um "gmail", o destino não importa;
	<br/>-Sem cripitografia, apenas envio de e-mail;
	<br/>-Por ser de graça, pode demorar um pouco, pq o Heroku deixa a aplicação dormindo quando não está em uso.
	<br/>-Tem a opção ultilizando um e-mail padrão da própia API não tem muito segredo.
	<br/>-Este é o JSON ultilizado: 
{
  "usuario": {
    "email": "Endereço e-mail remetente",
    "senha": "Senha remetente"
  },
  "destinatario": "Endereço e-mail destinatário",
  "assunto": "Assunto",
  "corpo": "Corpo"
}
	<br/>-URL passando os dados completos: https://enviadoremail.herokuapp.com/api METODO: POST
	<br/>-URL usando e-mail da API: https://enviadoremail.herokuapp.com/api/usaremailpadrao METODO: POST
