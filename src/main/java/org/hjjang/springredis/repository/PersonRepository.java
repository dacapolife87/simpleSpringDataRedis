package org.hjjang.springredis.repository;

        import org.hjjang.springredis.domain.PersonProfileVo;
        import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<PersonProfileVo, String> {
}
