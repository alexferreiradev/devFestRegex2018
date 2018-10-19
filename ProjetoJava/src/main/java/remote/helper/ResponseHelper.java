package remote.helper;

public final class ResponseHelper {

	public static String converResponse(Object response) throws IllegalArgumentException {
		if (response instanceof String) {
			return ((String) response);
		}

		throw new IllegalArgumentException("Resposta não é valida");
	}
}
