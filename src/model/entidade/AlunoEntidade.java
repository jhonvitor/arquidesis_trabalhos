package model.entidade;

public class AlunoEntidade {

	private int cod;
	private String nome;
	private String end;
	private String num;
	private String comp;
	private String dataNasc;
	private String email;
	private String telRes;
	private String telCel;
	private String rg;
	private String cpf;

	public AlunoEntidade() {

		this(0, "", "", "", "", "", "", "", "", "", "");
	}

	public AlunoEntidade(int cod, String nome, String end, String num,
			String comp, String dataNasc, String email, String telRes,
			String telCel, String rg, String cpf) {

		setCod(cod);
		setNome(nome);
		setEnd(end);
		setNum(num);
		setComp(comp);
		setDataNasc(dataNasc);
		setEmail(email);
		setTelRes(telRes);
		setTelCel(telCel);
		setRg(rg);
		setCpf(cpf);
	}

	public String getTelRes() {
		return telRes;
	}

	public void setTelRes(String telRes) {
		this.telRes = telRes;
	}

	public String getTelCel() {
		return telCel;
	}

	public void setTelCel(String telCel) {
		this.telCel = telCel;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome.toUpperCase();
	}

	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}

	public String getEnd() {
		return end.toUpperCase();
	}

	public void setEnd(String end) {
		this.end = end.toUpperCase();
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getComp() {
		return comp.toUpperCase();
	}

	public void setComp(String comp) {
		this.comp = comp.toUpperCase();
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlunoEntidade other = (AlunoEntidade) obj;
		if (cod != other.cod)
			return false;
		if (comp == null) {
			if (other.comp != null)
				return false;
		} else if (!comp.equals(other.comp))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataNasc == null) {
			if (other.dataNasc != null)
				return false;
		} else if (!dataNasc.equals(other.dataNasc))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (num == null) {
			if (other.num != null)
				return false;
		} else if (!num.equals(other.num))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (telCel == null) {
			if (other.telCel != null)
				return false;
		} else if (!telCel.equals(other.telCel))
			return false;
		if (telRes == null) {
			if (other.telRes != null)
				return false;
		} else if (!telRes.equals(other.telRes))
			return false;
		return true;
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cod;
		result = prime * result + ((comp == null) ? 0 : comp.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result
				+ ((dataNasc == null) ? 0 : dataNasc.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((num == null) ? 0 : num.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result + ((telCel == null) ? 0 : telCel.hashCode());
		result = prime * result + ((telRes == null) ? 0 : telRes.hashCode());
		return result;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
}
