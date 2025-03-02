package webApp.company.trello.list.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import webApp.company.trello.board.model.Board;
import webApp.company.trello.board.service.BoardService;
import webApp.company.trello.card.model.Card;
import webApp.company.trello.card.service.CardService;
import webApp.company.trello.list.controller.CatalogController;
import webApp.company.trello.list.model.Catalog;
import webApp.company.trello.list.service.CatalogService;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class CatalogControllerImpl implements CatalogController {
    private final CatalogService catalogService;
    private final BoardService boardService;
    private final CardService cardService;

    @Override
    public String getAddCardPage(Integer catalogId, Model model) {

        model.addAttribute("catalogId", catalogId);
        model.addAttribute("boardId", catalogService.findById(catalogId).get().getBoard().getId());

        return "add-card";
    }

    @Override
    public String addCardToCatalog(Integer catalogId, String cardTitle, String cardDescription) {

        Optional<Catalog> optionalCatalog = catalogService.findById(catalogId);

        if (optionalCatalog.isEmpty()) {
            throw new RuntimeException();
        }


        Catalog catalog = optionalCatalog.get();

        Card card = Card.builder()
                .title(cardTitle)
                .description(cardDescription)
                .catalog(catalog)
                .build();

        catalog.getCardList().add(card);
        cardService.saveCard(card);

        Integer boardId = catalog.getBoard().getId();

        return "redirect:/api/v1/board/" + boardId;

    }

    @Override
    public String getAddCatalogPage(Integer boardId, Model model) {

        model.addAttribute("boardId", boardId);
        return "add-catalog";
    }

    @Override
    public String createCatalog(Integer boardId, String title) {

        Board board = boardService.getBoardById(boardId);

        Catalog catalog = Catalog.builder()
                .title(title)
                .board(board)
                .build();

        board.getCatalogList().add(catalog);

        catalogService.saveCatalog(catalog);

        return "redirect:/api/v1/board/" + boardId;
    }

    @Override
    public ResponseEntity<Void> deleteCatalog(Integer catalogId) {
        catalogService.deleteListById(catalogId);

        return ResponseEntity.noContent().build();
    }

    @Override
    public String getEditPage(Integer catalogId, Model model) {
        Catalog catalog = catalogService.findById(catalogId).get();

        model.addAttribute("catalog", catalog);
        return "edit-catalog";
    }

    @Override
    public String editCatalog(Integer catalogId, String title) {

        Catalog catalog = catalogService.findById(catalogId).get();

        Board board = catalog.getBoard();
        board.getCatalogList().remove(catalog);
        catalog.setTitle(title);
        board.getCatalogList().add(catalog);

        catalogService.saveCatalog(catalog);

        return "redirect:/api/v1/board/" + board.getId();
    }

//    @Override
//    public void saveList(Integer boardId, CatalogRequest catalogRequest) {
//        catalogService.saveList(boardId, catalogRequest);
//    }
//
//    @Override
//    public void updateList(Integer catalogId, CatalogRequest catalogRequest) {
//        catalogService.updateList(catalogId, catalogRequest);
//    }
//
//    @Override
//    public void deleteList(Integer listId) {
//        catalogService.deleteListById(listId);
//    }


}
