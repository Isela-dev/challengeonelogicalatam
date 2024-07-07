const encriptar = () => {
	const inputText = document.getElementById("text").value;
	let result = "";
	for (let i = 0; i < inputText.length; i++) {
		switch(inputText[i]) {
			case "e":
				result += "enter";
				break;
			case "i":
				result += "imes";
				break;
			case "a":
				result += "ai";
				break;
			case "o":
				result += "ober";
				break;
			case "u":
				result += "ufat";
				break;
			default:
				result += inputText[i];
		}
	}
	document.getElementById("result").value = result;
};



const desencriptar = () => {
	const inputText = document.getElementById("text").value;
	let result = "";
	for (let i = 0; i < inputText.length; i++) {
		switch(inputText.substring(i, i+5)) {
			case "enter":
				result += "e";
				i += 4;
				break;
			case "imes":
				result += "i";
				i += 3;
				break;
			case "ai":
				result += "a";
				i += 1;
				break;
			case "ober":
				result += "o";
				i += 3;
				break;
			case "ufat":
				result += "u";
				i += 3;
				break;
			default:
				result += inputText[i];
		}
	}
	document.getElementById("result").value = result;
};

const copy = () => {
	const resultText = document.getElementById("result");
	resultText.select();
	resultText.setSelectionRange(0, 99999);
	document.execCommand("copy");
	alert("Texto copiado al portapapeles!");
};

document.getElementById("encrypt-btn").addEventListener("click", encriptar);
document.getElementById("decrypt-btn").addEventListener("click", desencriptar);