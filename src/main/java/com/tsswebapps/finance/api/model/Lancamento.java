package com.tsswebapps.finance.api.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.tsswebapps.finance.api.enums.TipoLancamento;

import lombok.Data;

@Data
@Entity
public class Lancamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private TipoLancamento lanTipo;
	
	private Double lanValor;
	
	private LocalDateTime lanData;
	
	private String lanDescricao;
	
	@CreationTimestamp
	private LocalDateTime createdAt;
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id", name = "lan_categoria", nullable = false)
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id", name = "lan_conta", nullable = false)
	private Conta conta;
}
