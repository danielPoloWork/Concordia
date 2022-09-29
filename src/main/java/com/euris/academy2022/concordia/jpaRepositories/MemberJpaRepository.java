package com.euris.academy2022.concordia.jpaRepositories;

import com.euris.academy2022.concordia.dataPersistences.dataModels.Member;
import com.euris.academy2022.concordia.utils.enums.MemberRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface MemberJpaRepository extends JpaRepository<Member, String> {


    String INSERT_INTO_MEMBER =
            "INSERT INTO Member (Member.id, Member.name, Member.surname, Member.role) "
                    + "VALUES (:id, :name, :surname, :role)";



    @Modifying
    @Query(value = INSERT_INTO_MEMBER, nativeQuery = true)
    @Transactional
    Optional<Member> insert(
            @Param("id") String id,
            @Param("name") String name,
            @Param("surname") String surname,
            @Param("role") String role
    );


    List<Member> findByName(String name);
    List<Member> findBySurname(String surname);
    List<Member> findByRole(String role);

}