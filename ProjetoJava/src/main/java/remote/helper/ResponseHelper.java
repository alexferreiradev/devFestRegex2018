package remote.helper;

public final class ResponseHelper {

	public static String convertResponse(Object response) throws IllegalArgumentException {
		if (response instanceof String) {
			return ((String) response);
		}

		throw new IllegalArgumentException("Resposta não é valida");
	}
}
