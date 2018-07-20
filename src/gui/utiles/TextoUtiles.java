package gui.utiles;

public class TextoUtiles {


	public String Capitalizar(String entrada) {
		String capitalizar = null;
		if (entrada == null || entrada.isEmpty()) {
			return capitalizar;
		}
		
		String[] part = entrada.split(" ");
		capitalizar = part[0].substring(0, 1).toUpperCase() + part[0].substring(1, part[0].length()).toLowerCase();
		for(int i = 1; i < part.length; i++) {
			capitalizar = capitalizar.concat(" "+part[i].substring(0, 1).toUpperCase() + part[i].substring(1, part[i].length()).toLowerCase());
		}
		return capitalizar;
	}
}

