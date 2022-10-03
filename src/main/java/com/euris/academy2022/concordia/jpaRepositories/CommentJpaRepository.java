package com.euris.academy2022.concordia.jpaRepositories;

import com.euris.academy2022.concordia.dataPersistences.dataModels.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface CommentJpaRepository extends JpaRepository<Comment, String> {


    String INSERT_INTO_COMMENT =
            "INSERT INTO Comment (Comment.uuid, Comment.text, Comment.lastUpdate, Comment.idTask, Comment.idMember) "
                    + "VALUES (UUID(), :text, :lastUpdate, :idTask, :idMember)";

    String UPDATE_COMMENT =
            "UPDATE Comment "
                    + "SET Comment.text = :text "
                    + "WHERE Comment.uuid = :uuid";

    String DELETE_COMMENT =
            "DELETE FROM Comment "
            +"WHERE Comment.uuid = :uuid";

    @Modifying
    @Query(value = INSERT_INTO_COMMENT, nativeQuery = true)
    @Transactional
    Integer insert(
            @Param("text") String text,
            @Param("lastUpdate")LocalDateTime lastUpdate,
            @Param("idTask") String idTask,
            @Param("idMember") String idMember);

    @Modifying
    @Query(value = DELETE_COMMENT, nativeQuery = true)
    @Transactional
    Integer removeByUuid(
            @Param("uuid") String uuid
            );

    @Modifying
    @Query(value = UPDATE_COMMENT, nativeQuery = true)
    @Transactional
    Integer update(
            @Param("text") String text,
            @Param("uuid") String uuid
    );

    List<Comment> findByIdTask(String idTask);
    List<Comment> findByIdMember(String idMember);
    String deleteByUuid(String uuid);

    Optional<Comment> findByUuid(String uuid);
}
