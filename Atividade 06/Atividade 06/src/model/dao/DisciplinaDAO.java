package model.dao;

import java.util.List;

import model.entities.Disciplina;

public interface DisciplinaDAO {

	void insert(Disciplina obj);
	void update(Disciplina obj);
	void deleteById(int i);
	Disciplina findById(int i);
	List<Disciplina> findAll();
	
}
