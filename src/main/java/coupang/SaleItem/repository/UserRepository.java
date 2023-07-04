package coupang.SaleItem.repository;

import coupang.SaleItem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
