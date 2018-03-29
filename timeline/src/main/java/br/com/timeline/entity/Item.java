package br.com.timeline.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "item")
@Table(name = "item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

	@Id
	@GeneratedValue
	private int id;

	@Size(min = 1, message = "Título não pode ser vazio!!")
	@NotNull(message = "Título não pode ser nulo")
	private String titulo;

	@Size(min = 1, message = "Descrição não pode ser vazio!!")
	@NotNull(message = "Descrição não pode ser nulo")
	private String descricao;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull(message = "Data não pode ser nulo")
	private Date data;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public String toString() {
		return titulo + " - " + formatarData(data);
	}

	private String formatarData(Date data){
		return new SimpleDateFormat("dd/MM/yy HH:mm").format(data);
	}

}
