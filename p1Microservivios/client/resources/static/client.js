
async function consultarTarea() {
  var texto = document.getElementById("text").value;

	document.getElementById("formTask").action += "consult/" + texto;
	document.getElementById("formTask").submit();
  }
  
async function enviarTarea() {
  var texto = document.getElementById("text").value;

	document.getElementById("formTask").action += texto;
	document.getElementById("formTask").submit();
  }


//debería funcionar pero no funciona
async function enviarTarea() {
	let socket = new WebSocket("ws://localhost:8084/tasks/consult/");
//coges el id , porque la caja que se llama text del html, lo contiene (lo ha introducido el usuario)
	let outgoingMessage =  document.getElementById("text").value;

	socket.send(outgoingMessage);
}
