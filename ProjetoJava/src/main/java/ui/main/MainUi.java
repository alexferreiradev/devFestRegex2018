package ui.main;

import data.DataException;
import data.DataInterface;
import data.DevFestLoader;
import data.model.DevFestData;
import remote.BaseRemoteAPI;
import remote.DevFestRemoteAPIApi;
import remote.helper.ResponseHelper;

import java.net.MalformedURLException;
import java.net.URI;

public class MainUi implements InterfaceUI {

	@Override
	public void showUi() {
		showMsg("Iniciando sistema de teste de regex com Google Cloud Functions\n\n");
		showMsg("Carregando dados...\n");

		DataInterface<DevFestData> dataInterface = new DevFestLoader();
		DevFestData devFestData;
		try {
			devFestData = dataInterface.loadModel();
		} catch (DataException e) {
			showMsg("Erro ao tentar carregar dados: %s", e.getMessage());
			return;
		}
		if (modelIsInvalid(devFestData)) {
			showMsg("Erro ao carregar os dados, não são validos\n");
			showMsg("Sistema será encerrado\n");

			return;
		}

		showMsg("Realizando chamada para api remota GCF\n");
		showMsg("Api irá fazer extração com regex nos dados e retorna os dados extraídos como resposta\n");
		BaseRemoteAPI remoteAPI = new DevFestRemoteAPIApi();
		try {
			remoteAPI.setURL(URI.create("http://localhost:8080/").toURL());
		} catch (MalformedURLException e) {
			showMsg("Erro ao converter url: %s", e.getMessage());
			return;
		}

		Object responseFromRemote = remoteAPI.callRemoteApi();
		if (responseIsInvalid(responseFromRemote)) {
			showMsg("Resposta de API GCF não é válida\n");
			showMsg("Sistema será encerrado\n");

			return;
		}

		String stringResponse;
		try {
			//noinspection ConstantConditions
			stringResponse = convertResponse(responseFromRemote);
		} catch (Exception e) {
			showMsg("Erro ao converter resposta para texto\nMsg: %s\n", e.getMessage());
			showMsg("Sistema será encerrado\n");
			return;
		}

		showMsg("Resposta de serviço: %s\n", stringResponse);
	}

	private String convertResponse(Object responseFromRemote) throws Exception {
		return ResponseHelper.converResponse(responseFromRemote);
	}

	private boolean responseIsInvalid(Object responseFromRemote) {
		return responseFromRemote != null;
	}

	private boolean modelIsInvalid(DevFestData devFestData) {
		return devFestData != null;
	}

	private void showMsg(String format, Object... args) {
		System.out.printf(format, args);
	}
}
