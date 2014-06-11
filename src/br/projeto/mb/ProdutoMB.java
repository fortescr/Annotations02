package br.projeto.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.projeto.anotacao.AnotacaoBase;
import br.projeto.entity.Entity;
import br.projeto.entity.Produto;

@ManagedBean
@ViewScoped
@AnotacaoBase(baseEntity=Produto.class)
public class ProdutoMB extends BaseMB {

	@Override
	public Entity getBaseEntity() {
		return (Produto) baseEntity;
	}

}
