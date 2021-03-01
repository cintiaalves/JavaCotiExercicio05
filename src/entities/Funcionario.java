package entities;

public class Funcionario {
	
	private Integer idFuncionario;
	private String nome;
	private String cpf;
	private Double salario;
	
	
	public Funcionario() {
		// TODO Auto-generated constructor stub
	}

	public Funcionario(Integer idFuncionario, String nome, String cpf, Double salario) {
		super();
		this.idFuncionario = idFuncionario;
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
	}

	//..................................................................................................//
	
	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	//............................................................................................//
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " Funcionario [idFuncionario= " + idFuncionario + ", nome= " + nome + ", cpf= " + cpf + ", salario= " + salario + "]";
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Funcionario) {
			Funcionario funcionario = (Funcionario) obj;
			return this.idFuncionario.equals(funcionario.getIdFuncionario())
					&& this.cpf.equals(funcionario.getCpf())
					&& this.nome.equals(funcionario.getNome())
					&& this.salario.equals(funcionario.getSalario());
		}
		return false;
	}
	
	
	@Override
	public int hashCode() {
		return this.idFuncionario.hashCode();
	}
	

}
