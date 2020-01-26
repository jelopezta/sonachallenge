function convertNumber() {
	let basePath = document.location.origin + '/sonatypechallenge/rest/englishconverter/767534';
	fetch(basePath)
	  .then((response) => {
	    return response.text();
	  })
	  .then((text) => {
		 var resultLabel =document.getElementById('responseLabel')
		 resultLabel.innerText = text;
	  });
}

function clearResult() {
		 var resultLabel =document.getElementById('responseLabel')
		 resultLabel.innerText = '';
}