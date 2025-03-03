package webApp.company.trello.list.service;

import webApp.company.trello.list.dto.CatalogRequest;
import webApp.company.trello.list.model.Catalog;

import java.util.Optional;

public interface CatalogService {

    /**
     * Сохраняет новый список (каталог) в указанной доске.
     *
     * @param boardId Идентификатор доски, в которую добавляется список.
     * @param catalogRequest Объект {@link CatalogRequest}, содержащий данные для создания списка.
     */
    void saveList(Integer boardId, CatalogRequest catalogRequest);

    /**
     * Обновляет существующий список (каталог) по его идентификатору.
     *
     * @param catalogId Идентификатор списка, который необходимо обновить.
     * @param catalogRequest Объект {@link CatalogRequest}, содержащий новые данные для обновления списка.
     */
    void updateList(Integer catalogId, CatalogRequest catalogRequest);

    /**
     * Удаляет список (каталог) по его идентификатору.
     *
     * @param listId Идентификатор списка, который необходимо удалить.
     */
    void deleteListById(Integer listId);

    /**
     * Находит список (каталог) по его идентификатору.
     *
     * @param catalogId Идентификатор списка, который необходимо найти.
     * @return {@link Optional}, содержащий объект {@link Catalog}, если список найден, или пустой {@link Optional}, если список не найден.
     */
    Optional<Catalog> findById(Integer catalogId);

    /**
     * Сохраняет список (каталог) в системе.
     *
     * @param catalog Объект {@link Catalog}, представляющий список, который необходимо сохранить.
     */
    void saveCatalog(Catalog catalog);
}
