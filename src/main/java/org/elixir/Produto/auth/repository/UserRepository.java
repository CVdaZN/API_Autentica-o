package org.elixir.Produto.auth.repository;

import org.elixir.Produto.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long > {

    User findByUsername(String username);
}
