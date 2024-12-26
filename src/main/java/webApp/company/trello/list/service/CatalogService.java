package webApp.company.trello.list.service;

import webApp.company.trello.list.dto.CatalogRequest;

public interface CatalogService {

    void saveList(Integer boardId, CatalogRequest catalogRequest);

    void updateList(Integer catalogId, CatalogRequest catalogRequest);
}
