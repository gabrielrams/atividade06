package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.db.DB;
import model.entities.Disciplina;

public class DisciplinaDaoImpl implements DisciplinaDAO {
	
	private Connection conexao;
	

	public DisciplinaDaoImpl(Connection conexao) {
		this.conexao = conexao;
	}

	@Override
	public void insert(Disciplina obj) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			pst = conexao.prepareStatement("INSERT INTO disciplina (nomedisciplina, cargahoraria) VALUES (?,?)", 
											Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1, obj.getNomedisciplina());
			pst.setInt(2, obj.getCargahoraria());

			int linhas = pst.executeUpdate();
			
			if (linhas > 0) {
				rs = pst.getGeneratedKeys();
				if (rs.next()) {
					obj.setIdDisciplina(rs.getInt("iddisciplina"));
				}
				System.out.println("    |     Disciplina [ " 
									+ obj.getIdDisciplina() + " | " 
									+  obj.getNomedisciplina() + " | "
									+ obj.getCargahoraria() + " ] "
									+ " foi criado com sucesso!");
			}
			else {
				System.out.println("    Não foi possível cadastrar a Disciplina!");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.fechaPreparedStatement(pst);
			DB.fechaResultSet(rs);
		}
		
	}

	@Override
	public void update(Disciplina obj) {
		PreparedStatement pst = null;
		 
		try {
			
			pst = conexao.prepareStatement("UPDATE disciplina SET nomedisciplina = ?, cargahoraria = ? WHERE iddisciplina = ?");
			
			pst.setString(1,obj.getNomedisciplina());
			pst.setInt(2, obj.getCargahoraria());
			pst.setInt(3, obj.getIdDisciplina());
			
			int linhas = pst.executeUpdate();
			
			if(linhas > 0) {
				System.out.println("    Disciplina [ " 
						+ obj.getIdDisciplina() + " | " 
						+ obj.getNomedisciplina() + " ] "
						+ " alterado com sucesso!");
				}else {
					System.out.println("    Não foi realizada a alteração da Disciplina!");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DB.fechaPreparedStatement(pst);
		}
		
	}

	@Override
	public void deleteById(int i) {
		PreparedStatement pst = null;
		
		try {
			pst = conexao.prepareStatement("DELETE FROM disciplina WHERE iddisciplina = ?");
			pst.setInt(1, i);
			
			int linhas = pst.executeUpdate();
			
			if (linhas > 0) {	
				System.out.println("    Curso [" + i + "] excluído com sucesso!");
			}
			else {
				System.out.println("    Não foi possível excluir o Curso id[" + i + "] !");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DB.fechaPreparedStatement(pst);
		}
		
	}

	@Override
	public Disciplina findById(int i) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
		pst = conexao.prepareStatement("SELECT * FROM disciplina WHERE iddisciplina = ?");
		pst.setInt(1, i);
		
		rs = pst.executeQuery();
			if(rs.next()) {
				Disciplina obj = new Disciplina();
				obj.setIdDisciplina(rs.getInt("iddisciplina"));
				obj.setNomedisciplina(rs.getString("nomedisciplina"));
				obj.setCargahoraria(rs.getInt("cargahoraria"));
				return obj;
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			DB.fechaPreparedStatement(pst);
			DB.fechaResultSet(rs);
		}
		return null;
		
		
	}

	@Override
	public List<Disciplina> findAll() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Disciplina> lista = new ArrayList<>();	
		
		try {
			pst = conexao.prepareStatement("SELECT * FROM disciplina");
			rs = pst.executeQuery();
			while (rs.next()) {   
				Disciplina d = new Disciplina(rs.getInt("iddisciplina"), rs.getString("nomedisciplina"), rs.getInt("cargahoraria"));
				lista.add(d);
			}
		}
		catch (SQLException e) {
			System.out.println(e);
		}
		finally {
			DB.fechaPreparedStatement(pst);
			DB.fechaResultSet(rs);
		}
		return lista;
	}
 
	
}
