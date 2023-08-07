package com.example.mithbin.infra.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class AuditingConfig implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // Retorna o nome do usuário atual (pode ser lido da autenticação)
        return Optional.of("usuário-atual");
    }
}
