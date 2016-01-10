package com.akira.in.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akira.in.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	/*
	 * @Query(nativeQuery = true, value =
	 * "select * from subscriber where (sub_state='SUSPEND' or sub_state='PARKING') and now() >= sub_next_cycle_date"
	 * ) List<Subscriber> findRemovableSubscribers();
	 */
	Set<User> findByUnameAndPassword(String uame, String password);
}
