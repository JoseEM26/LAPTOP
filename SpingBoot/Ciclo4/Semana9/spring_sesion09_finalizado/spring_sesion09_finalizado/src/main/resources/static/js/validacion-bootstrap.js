document.addEventListener("DOMContentLoaded", function () {
	const formElements = document.querySelectorAll(
		"input.form-control, select.form-select, textarea.form-control, input[type='radio'], input[type='checkbox']"
	);

	formElements.forEach(element => {
		const feedback = element.parentElement.querySelector(".invalid-feedback");

		element.addEventListener("input", () => {
			element.classList.remove("is-invalid");
			if (feedback) {
				feedback.style.display = "none";
			}
		});

		element.addEventListener("blur", () => {
			if (
				(element.type === "checkbox" || element.type === "radio")
					? !element.checked
					: !element.value.trim()
			) {
				element.classList.add("is-invalid");
				if (feedback) {
					feedback.style.display = "block";
				}
			}
		});
	});
});
