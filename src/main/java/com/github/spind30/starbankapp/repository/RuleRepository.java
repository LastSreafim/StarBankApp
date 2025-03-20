package com.github.spind30.starbankapp.repository;

import com.github.spind30.starbankapp.model.rule.DynamicRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RuleRepository extends JpaRepository<DynamicRule, UUID> {

}
