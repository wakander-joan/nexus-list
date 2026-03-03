package com.nexus.nexus_list.user.infra;

import com.nexus.nexus_list.user.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientSpringDataJPARepository extends JpaRepository<Client, UUID> {
}
