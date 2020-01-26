function convertNumber() {
	var numberInput = document.getElementById('numberToTransform');
	let basePath = document.location.origin + '/sonatypechallenge/rest/englishconverter/' + numberInput.value;
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
		 var numberInput = document.getElementById('numberToTransform');
		 numberInput.value = '';
}