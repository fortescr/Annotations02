package br.projeto.mb;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import br.projeto.anotacao.AnotacaoBase;
import br.projeto.entity.Entity;
import br.projeto.model.BaseDAO;

public abstract class BaseMB {
	
	protected BaseDAO baseDAO;
	protected List<Entity> listEntity;
	protected Entity baseEntity;
	public abstract Entity getBaseEntity();
	
	public BaseMB(){
		baseDAO = new BaseDAO();
		
		try {
			prepareListAction();
			baseEntity = createNewBaseEntity();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected Entity createNewBaseEntity() throws Exception {
		return getAnotacaoBase().baseEntity().newInstance();
	}
	
	public AnotacaoBase getAnotacaoBase() throws Exception {
		String className = getClass().getName();
		int index = className.indexOf('$');
		index = index >= 0 ? index : className.length();
		className = StringUtils.left(className, index);
		Class targetClass = getClass().getClassLoader().loadClass(className);
		if (targetClass.isAnnotationPresent(AnotacaoBase.class)) {
			return (AnotacaoBase) targetClass.getAnnotation(AnotacaoBase.class);
		}
		return null;
	}
	
	public String salvar() throws Exception{
		baseDAO.salvar(baseEntity);
		prepareListAction();
		return "";
	}
	
	public String excluir() throws Exception{
		baseDAO.excluir(baseEntity);
		prepareListAction();
		return "";
	}
	
	public String prepareListAction() throws Exception {
		
		listEntity = (List<Entity>) baseDAO.getLista(getAnotacaoBase().baseEntity());
		
		return "";
	}

	public List<Entity> getListEntity() {
		return listEntity;
	}

	public void setListEntity(List<Entity> listEntity) {
		this.listEntity = listEntity;
	}

	public void setBaseEntity(Entity baseEntity) {
		this.baseEntity = baseEntity;
	}
	
}
