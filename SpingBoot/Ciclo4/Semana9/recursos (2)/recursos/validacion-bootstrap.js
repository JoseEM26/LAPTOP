document.addEventListener("DOMContentLoaded", function() {
	const inputs = document.querySelectorAll(".form-control");

	inputs.forEach(input => {
		const feedback = input.parentElement.querySelector(".invalid-feedback");

		input.addEventListener("input", () => {
			input.classList.remove("is-invalid");
			if (feedback) {
				feedback.style.display = "none";
			}
		});

		input.addEventListener("blur", () => {
			if (!input.value.trim()) {
				input.classList.add("is-invalid");
				if (feedback) {
					feedback.style.display = "block";
				}
			}
		});
	});
});