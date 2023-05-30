package model.entities;

public class Disciplina {

	private int idDisciplina;
	private String nomedisciplina;
	private int cargahoraria;
	
	public Disciplina(int idDisciplina, String nomedisciplina, int cargahoraria) {
		this.idDisciplina = idDisciplina;
		this.nomedisciplina = nomedisciplina;
		this.cargahoraria = cargahoraria;
	}

	public Disciplina() {

	}

	public int getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getNomedisciplina() {
		return nomedisciplina;
	}

	public void setNomedisciplina(String nomedisciplina) {
		this.nomedisciplina = nomedisciplina;
	}

	public int getCargahoraria() {
		return cargahoraria;
	}

	public void setCargahoraria(int cargahoraria) {
		this.cargahoraria = cargahoraria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cargahoraria;
		result = prime * result + idDisciplina;
		result = prime * result + ((nomedisciplina == null) ? 0 : nomedisciplina.hashCode());
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
		Disciplina other = (Disciplina) obj;
		if (cargahoraria != other.cargahoraria)
			return false;
		if (idDisciplina != other.idDisciplina)
			return false;
		if (nomedisciplina == null) {
			if (other.nomedisciplina != null)
				return false;
		} else if (!nomedisciplina.equals(other.nomedisciplina))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Disciplina [idDisciplina=" + idDisciplina + ", nomedisciplina=" + nomedisciplina + ", cargahoraria="
				+ cargahoraria + "]";
	}


	
	
	
	
}
