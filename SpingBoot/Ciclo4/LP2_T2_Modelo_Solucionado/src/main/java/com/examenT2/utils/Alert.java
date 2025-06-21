package com.examenT2.utils;

public class Alert {

	public static String sweetAlertInfo(String text) {
		return sweetAlert("Información", text, "info");
	}

	public static String sweetAlertSuccess(String text) {
		return sweetAlert("Exitoso", text, "success");
	}

	public static String sweetAlertError(String text) {
		return sweetAlert("Error", text, "error");
	}

	public static String sweetAlert(String title, String text, String icon) {
		String scriptText = """
				<script>
				    Swal.fire({
				        title: '%s',
				        text: '%s',
				        icon: '%s'
				    });
				</script>
				""";

		return String.format(scriptText, title, text, icon);
	}

	public static String sweetToast(String title, String icon, int timer) {
		String scriptText = """
				<script>
				    const Toast = Swal.mixin({
				        toast: true,
				        position: 'top-end',
				        showConfirmButton: false,
				        timer: %d,
				        timerProgressBar: true,
				        didOpen: (toast) => {
				            toast.onmouseenter = Swal.stopTimer;
				            toast.onmouseleave = Swal.resumeTimer;
				        }
				    });
				    Toast.fire({
				        icon: '%s',
				        title: '%s'
				    });
				</script>
				""";

		return String.format(scriptText, timer, icon, title);
	}

}
