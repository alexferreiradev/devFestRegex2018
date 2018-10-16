package ui.main;

import data.DataInterface;
import data.model.DevFestData;
import remote.BaseRemoteAPI;
import remote.DevFestRemoteAPIApi;

public class MainUi implements InterfaceUI {

	@Override
	public void showUi() {
		showMsg("Iniciando sistema de teste de regex com Google Cloud Functions\n\n");
		showMsg("Carregando dados...\n");

		DataInterface<DevFestData> dataInterface = new DevFestData();
		DevFestData devFestData = dataInterface.loadModel();
		if (modelIsInvalid(devFestData)) {
			showMsg("Erro ao carregar os dados, não são validos\n");
			showMsg("Sistema será encerrado\n");

			return;
		}

		showMsg("Realizando chamada para api remota GCF\n");
		showMsg("Api irá fazer extração com regex nos dados e retorna os dados extraídos como resposta\n");
		BaseRemoteAPI remoteAPI = new DevFestRemoteAPIApi();
		Object responseFromRemote = remoteAPI.callRemoteApi();
		if (responseIsInvalid(responseFromRemote)) {
			showMsg("Resposta de API GCF não é válida\n");
			showMsg("Sistema será encerrado\n");

			return;
		}

		String stringResponse;
		try {
			stringResponse = convertResponse(responseFromRemote);
		} catch (Exception e) {
			showMsg("Erro ao converter resposta para texto\nMsg: %s\n", e.getMessage());
			showMsg("Sistema será encerrado\n");
			return;
		}

		showMsg("Resposta de serviço: %s\n", stringResponse);
	}

	private String convertResponse(Object responseFromRemote) {
		return null;
	}

	private boolean responseIsInvalid(Object responseFromRemote) {
		return false;
	}

	private boolean modelIsInvalid(DevFestData devFestData) {
		return false;
	}

	private void showMsg(String format, Object... args) {
		System.out.printf(format, args);
	}
}