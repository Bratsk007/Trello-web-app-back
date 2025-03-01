package webApp.company.trello.list.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webApp.company.trello.board.dao.BoardDao;
import webApp.company.trello.board.model.Board;
import webApp.company.trello.list.dao.CatalogDao;
import webApp.company.trello.list.dto.CatalogRequest;
import webApp.company.trello.list.model.Catalog;
import webApp.company.trello.list.service.CatalogService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {
    private final CatalogDao catalogDao;
    private final BoardDao boardDao;

    @Override
    public void saveList(Integer boardId, CatalogRequest catalogRequest) {

        Optional<Board> optionalBoard = boardDao.findById(boardId);

        if (optionalBoard.isPresent()) {
            Board board = optionalBoard.get();

            Catalog catalog = Catalog.builder()
                    .title(catalogRequest.getTitle())
                    .board(board)
                    .build();

            board.getCatalogList().add(catalog);

            catalogDao.save(catalog);
        }


    }

    @Override
    public void updateList(Integer catalogId, CatalogRequest catalogRequest) {
        Optional<Catalog> optionalCatalog = catalogDao.findById(catalogId);

        if (optionalCatalog.isPresent()) {
            Catalog catalog = optionalCatalog.get();

            catalog.setTitle(catalogRequest.getTitle());

            catalogDao.save(catalog);
        }
    }

    @Override
    public void deleteListById(Integer listId) {
        Optional<Catalog> optionalCatalog = catalogDao.findById(listId);

        if (optionalCatalog.isPresent()) {
            Catalog catalog = optionalCatalog.get();

            catalogDao.delete(catalog);
        }
    }

    @Override
    public Optional<Catalog> findById(Integer catalogId) {
        return catalogDao.findById(catalogId);
    }

    @Override
    public void saveCatalog(Catalog catalog) {
        catalogDao.save(catalog);
    }


}
