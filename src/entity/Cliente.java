package entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable{ 
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCliente;
	@Column
	private String nomeCliente;	
	@Column
	private String dataNascimento; 
	@Column(unique=true) 
	private String emailCliente;
	
	public Cliente() {
	}

	public Cliente(Long idCliente, String nomeCliente, String dataNascimento, String emailCliente) {
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		this.dataNascimento = dataNascimento;
		this.emailCliente = emailCliente;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		return "Cliente [idCliente=" + idCliente + ", nomeCliente=" + nomeCliente + ", dataNascimento=" + sdf.format(dataNascimento)
				+ ", emailCliente=" + emailCliente + "]";
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
