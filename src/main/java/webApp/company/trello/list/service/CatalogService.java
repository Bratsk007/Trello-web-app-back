package webApp.company.trello.list.service;

import webApp.company.trello.list.dto.CatalogRequest;
import webApp.company.trello.list.model.Catalog;

import java.util.Optional;

public interface CatalogService {

    void saveList(Integer boardId, CatalogRequest catalogRequest);

    void updateList(Integer catalogId, CatalogRequest catalogRequest);


    void deleteListById(Integer listId);

    Optional<Catalog> findById(Integer catalogId);

    void saveCatalog(Catalog catalog);
}
