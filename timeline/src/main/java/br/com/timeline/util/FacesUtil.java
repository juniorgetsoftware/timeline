package br.com.timeline.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

public class FacesUtil {

	public static void addMsgInfo(String id, String msg, String desc) {
		FacesContext.getCurrentInstance().addMessage(id, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, desc));
		PrimeFaces.current().ajax().update(id);
	}

	public static void addMsgAtencao(String id, String msg, String desc) {
		FacesContext.getCurrentInstance().addMessage(id, new FacesMessage(FacesMessage.SEVERITY_WARN, msg, desc));
		PrimeFaces.current().ajax().update(id);
	}

}
