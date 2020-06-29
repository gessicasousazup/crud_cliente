package br.com.zup.crud_cliente.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.crud_cliente.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
