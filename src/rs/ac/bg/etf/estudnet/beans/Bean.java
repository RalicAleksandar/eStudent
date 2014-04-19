package rs.ac.bg.etf.estudnet.beans;

import java.util.HashMap;
import java.util.Map;

public class Bean {

	private Upis upis;
	private String rata;
	private String brojRata;
	private String iznos;
	private String rokUplate;
	
	public Map<String,String> getMap(){
		Map<String,String> temp = upis.getMap();
		temp.put("rata", rata);
		temp.put("brojRata", brojRata);
		temp.put("iznos", iznos);
		temp.put("rokUplate", rokUplate);
		return temp;
	}

	public Upis getUpis() {
		return upis;
	}

	public String getRata() {
		return rata;
	}

	public String getBrojRata() {
		return brojRata;
	}

	public String getIznos() {
		return iznos;
	}

	public String getRokUplate() {
		return rokUplate;
	}

	public void setUpis(Upis upis) {
		this.upis = upis;
	}

	public void setRata(String rata) {
		this.rata = rata;
	}

	public void setBrojRata(String brojRata) {
		this.brojRata = brojRata;
	}

	public void setIznos(String iznos) {
		this.iznos = iznos;
	}

	public void setRokUplate(String rokUplate) {
		this.rokUplate = rokUplate;
	}

	public static class Upis {
		private String skolskaGodina;
		private String godinaStudija;
		private String statusUpisa;
		private String nacinUpisa;
		private String akronimProfil;
		private String nazivProfil;
		private String datumUpisa;
		private String espbOsvojeno;
		private String kojiPut;
		
		public Map<String,String> getMap(){
			HashMap<String,String> temp = new HashMap<String,String>();
			temp.put("skolskaGodina", skolskaGodina);
			temp.put("godinaStudija", godinaStudija);
			temp.put("statusUpisa", statusUpisa);
			temp.put("nacinUpisa", nacinUpisa);
			temp.put("akronimProfil", akronimProfil);
			temp.put("nazivProfil", nazivProfil);
			temp.put("datumUpisa", datumUpisa);
			temp.put("espbOsvojeno", espbOsvojeno);
			temp.put("kojiPut", kojiPut);
 			return temp;
		}

		public String getSkolskaGodina() {
			return skolskaGodina;
		}

		public String getGodinaStudija() {
			return godinaStudija;
		}

		public String getStatusUpisa() {
			return statusUpisa;
		}

		public String getNacinUpisa() {
			return nacinUpisa;
		}

		public String getAkronimProfil() {
			return akronimProfil;
		}

		public String getNazivProfil() {
			return nazivProfil;
		}

		public String getDatumUpisa() {
			return datumUpisa;
		}

		public String getEspbOsvojeno() {
			return espbOsvojeno;
		}

		public String getKojiPut() {
			return kojiPut;
		}

		public void setSkolskaGodina(String skolskaGodina) {
			this.skolskaGodina = skolskaGodina;
		}

		public void setGodinaStudija(String godinaStudija) {
			this.godinaStudija = godinaStudija;
		}

		public void setStatusUpisa(String statusUpisa) {
			this.statusUpisa = statusUpisa;
		}

		public void setNacinUpisa(String nacinUpisa) {
			this.nacinUpisa = nacinUpisa;
		}

		public void setAkronimProfil(String akronimProfil) {
			this.akronimProfil = akronimProfil;
		}

		public void setNazivProfil(String nazivProfil) {
			this.nazivProfil = nazivProfil;
		}

		public void setDatumUpisa(String datumUpisa) {
			this.datumUpisa = datumUpisa;
		}

		public void setEspbOsvojeno(String espbOsvojeno) {
			this.espbOsvojeno = espbOsvojeno;
		}

		public void setKojiPut(String kojiPut) {
			this.kojiPut = kojiPut;
		}

	}
}