package webApp.company.trello.list.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import webApp.company.trello.list.controller.CatalogController;
import webApp.company.trello.list.dto.CatalogRequest;
import webApp.company.trello.list.service.CatalogService;

@RestController
@RequiredArgsConstructor
public class CatalogControllerImpl implements CatalogController {
    private final CatalogService catalogService;

    @Override
    public void saveList(Integer boardId, CatalogRequest catalogRequest) {
        catalogService.saveList(boardId, catalogRequest);
    }

    @Override
    public void updateList(Integer catalogId, CatalogRequest catalogRequest) {
        catalogService.updateList(catalogId, catalogRequest);
    }

    @Override
    public void deleteList(Integer listId) {
        catalogService.deleteListById(listId);
    }


}
