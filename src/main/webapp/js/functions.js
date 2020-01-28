function convertNumber() {
	var numberInput = document.getElementById('numberToTransform');
	let basePath = document.location.origin + '/sonatypechallenge/rest/englishconverter/' + numberInput.value;
	if (numberInput.value !== "") {
		fetch(basePath)
			.then((response) => {
				return response.text();
			})
			.then((text) => {
				var resultLabel = document.getElementById('responseLabel')
				resultLabel.innerText = text;
			});
	} else {
		var resultLabel = document.getElementById('responseLabel')
		resultLabel.innerText = 'Number is empty or has an invalid value. Please check your input and try again';
	}

}

function clearResult() {
	var resultLabel = document.getElementById('responseLabel')
	resultLabel.innerText = '';
	var numberInput = document.getElementById('numberToTransform');
	numberInput.value = '';
}