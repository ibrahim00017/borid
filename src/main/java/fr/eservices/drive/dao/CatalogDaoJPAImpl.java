package fr.eservices.drive.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import fr.eservices.drive.model.Article;
import fr.eservices.drive.model.Category;
import fr.eservices.drive.model.Perishable;


public class CatalogDaoJPAImpl implements CatalogDao {
	@PersistenceContext
	private  EntityManager entityManager;

	public CatalogDaoJPAImpl(EntityManager em) {
		this.entityManager=em;
	}

	//@Override
	public  EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Category> getCategories() {
		String queryString = "SELECT t FROM Category t";
		Query query = this.entityManager.createQuery( queryString );
		List<Category> results = query.getResultList();
		return results;
	}

	@Override
	public List<Category> getArticleCategories(int id) {
		String queryString = "SELECT t FROM Article t WHERE t.id := id";
		Query query = this.entityManager.createQuery( queryString );
		query.setParameter( "id",id );
		Article article = (Article)query.getSingleResult();
		return article.getCategories();
	}

	@Override
	public List<Article> getCategoryContent(int categoryId) {
		String queryArt ="SELECT t FROM Article t";
		Query query = this.entityManager.createQuery( queryArt );
		List<Article> articles = query.getResultList();
		List<Article> result = new ArrayList<>(  );
		articles.forEach( t->{
			if(t.getCategories().stream().filter( item->item.getId()==categoryId ).findFirst().isPresent() ){
				result.add( t );
			}
		} );
		return result;
	}

	@Override
	public List<Perishable> getPerished(Date day) {
		String querystr = "SELECT t FROM t WHERE t.bestBefore:= day";
		Query query = this.entityManager.createQuery( querystr );
		List<Perishable> perishables = query.getResultList();
		return perishables;
	}

	
}
