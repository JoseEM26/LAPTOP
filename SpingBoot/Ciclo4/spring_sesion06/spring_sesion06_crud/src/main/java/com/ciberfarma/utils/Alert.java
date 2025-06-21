package com.ciberfarma.utils;

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
		String scriptText = "<script>Swal.fire({title: '%s', text: '%s', icon: '%s'})</script>";
		return String.format(scriptText, title, text, icon);
	}
}
