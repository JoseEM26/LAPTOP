document.getElementById('goToRegister').addEventListener('click', function() {
	document.querySelector('.panel-wrapper').classList.add('show-register'); // Desliza hacia el panel de registro
});

document.getElementById('goToLogin').addEventListener('click', function() {
	document.querySelector('.panel-wrapper').classList.remove('show-register'); // Desliza hacia el panel de login
});
