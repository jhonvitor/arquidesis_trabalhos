package model.entidade;

public class CursoEntidade {

	private int codgoCurso;
	private String curso;
	private String dataIni;
	private String dataFim;
	private String horaIni;
	private String horaFim;
	private int qdtVagas;
	private String livros;
	private String materiais;
	private double valor;
	
	public CursoEntidade(){
		
		this(0, "", "", "", "", "", 0, "", "", 0.0);
	}

	public CursoEntidade(int codgoCurso, String curso, String dataIni,
			String dataFim, String horaIni, String horaFim, int qdtVagas,
			String livros, String materiais, double valor) {
		
		setCodgoCurso(codgoCurso);
		setCurso(curso);
		setDataIni(dataIni);
		setDataFim(dataFim);
		setHoraIni(horaIni);
		setHoraFim(horaFim);
		setQdtVagas(qdtVagas);
		setLivros(livros);
		setMateriais(materiais);
		setValor(valor);

	}

	public int getCodgoCurso() {
		return codgoCurso;
	}

	public void setCodgoCurso(int codgoCurso) {
		this.codgoCurso = codgoCurso;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getDataIni() {
		return dataIni;
	}

	public void setDataIni(String dataIni) {
		this.dataIni = dataIni;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	public String getHoraIni() {
		return horaIni;
	}

	public void setHoraIni(String horaIni) {
		this.horaIni = horaIni;
	}

	public String getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(String horaFim) {
		this.horaFim = horaFim;
	}

	public int getQdtVagas() {
		return qdtVagas;
	}

	public void setQdtVagas(int qdtVagas) {
		this.qdtVagas = qdtVagas;
	}

	public String getLivros() {
		return livros;
	}

	public void setLivros(String livros) {
		this.livros = livros;
	}

	public String getMateriais() {
		return materiais;
	}

	public void setMateriais(String materiais) {
		this.materiais = materiais;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	

}
