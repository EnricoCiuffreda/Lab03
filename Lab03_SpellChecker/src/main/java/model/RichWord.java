package model;

public class RichWord {
	private String parola;
	private boolean corretto;
	
	public RichWord(String parola, boolean corretto) {
		super();
		this.parola = parola;
		this.corretto = corretto;
	}
	
	

	public String getParola() {
		return parola;
	}



	public void setParola(String parola) {
		this.parola = parola;
	}



	public boolean isCorretto() {
		return corretto;
	}



	public void setCorretto(boolean corretto) {
		this.corretto = corretto;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parola == null) ? 0 : parola.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RichWord other = (RichWord) obj;
		if (parola == null) {
			if (other.parola != null)
				return false;
		} else if (!parola.equals(other.parola))
			return false;
		return true;
	}



	@Override
	public String toString() {
		if(corretto==false && parola!="")
		return parola+"\n";
		else return "";
	}
	
	
	
	

}
