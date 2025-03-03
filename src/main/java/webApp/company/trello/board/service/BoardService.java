package webApp.company.trello.board.service;

import webApp.company.trello.board.dto.BoardListResponse;
import webApp.company.trello.board.dto.BoardRequest;
import webApp.company.trello.board.dto.BoardResponse;
import webApp.company.trello.board.model.Board;

import java.util.List;

public interface BoardService {

    /**
     * Возвращает список досок, связанных с указанным пользователем.
     *
     * @param userId Идентификатор пользователя, для которого необходимо получить список досок.
     * @return Список объектов {@link BoardListResponse}, представляющих доски пользователя.
     */
    List<BoardListResponse> getBoardsByUserId(Integer userId);

    /**
     * Сохраняет новую доску в системе.
     *
     * @param board Объект {@link Board}, представляющий доску, которую необходимо сохранить.
     */
    void saveBoard(Board board);

    /**
     * Обновляет существующую доску по её идентификатору.
     *
     * @param boardId Идентификатор доски, которую необходимо обновить.
     * @param boardRequest Объект {@link BoardRequest}, содержащий новые данные для обновления доски.
     */
    void updateBoard(Integer boardId, BoardRequest boardRequest);

    /**
     * Возвращает доску по её идентификатору.
     *
     * @param boardId Идентификатор доски, которую необходимо получить.
     * @return Объект {@link Board}, представляющий запрошенную доску.
     */
    Board getBoardById(Integer boardId);

    /**
     * Удаляет доску по её идентификатору.
     *
     * @param boardId Идентификатор доски, которую необходимо удалить.
     */
    void deleteBoardById(Integer boardId);
}
