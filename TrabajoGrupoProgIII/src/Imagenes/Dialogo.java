package Imagenes;

import java.util.List;

public class Dialogo {
private String txt;
private List<String> opc;
private int selec;

public Dialogo(String txt, List<String> opc) {
	super();
	this.txt = txt;
	this.opc = opc;
	this.selec = -1;
}

public String getTxt() {
	return txt;
}

public void setTxt(String txt) {
	this.txt = txt;
}

public List<String> getOpc() {
	return opc;
}

public void setOpc(List<String> opc) {
	this.opc = opc;
}

public int getSelec() {
	return selec;
}

public void setSelec(int selec) {
	this.selec = selec;
}


}
