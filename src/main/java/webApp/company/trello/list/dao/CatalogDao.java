package webApp.company.trello.list.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webApp.company.trello.list.model.Catalog;

@Repository
public interface CatalogDao extends JpaRepository<Catalog, Integer> {

}
