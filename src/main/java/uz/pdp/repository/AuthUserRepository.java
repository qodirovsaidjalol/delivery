package uz.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.entity.auth.AuthUser;
import uz.pdp.repository.AbstractRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long>, AbstractRepository {

    @Modifying
    @Transactional
    @Query("update AuthUser au set au.userName=:userName,au.password=:password,au.fullName=:fullName,au.position=:position where au.id=:id")
    void update(String userName, String password, String fullName, String position, Long id);

    @Modifying
    @Transactional
    @Query("update AuthUser au set au.completed=true,au.role=2 where au.id=:id")
    void completeUser(Long id);

    @Modifying
    @Transactional
    @Query("update AuthUser au set au.isBlocked=true where au.id=:id")
    void block(Long id);

    @Modifying
    @Transactional
    @Query("update AuthUser au set au.isBlocked=false where au.id=:id")
    void unBlock(Long id);

    @Modifying
    @Transactional
    @Query("update AuthUser au set au.deleted=true where au.id=:id")
    void delete(Long id);
}